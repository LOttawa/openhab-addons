/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.dwdweatherforecast.internal.connection;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.ZipInputStream;

import javax.xml.namespace.QName;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.ISO8601DateConverter;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import org.apache.commons.io.IOUtils;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.smarthome.core.cache.ExpiringCacheMap;
import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.library.types.PointType;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdForecastBridgeHandler;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdWeatherData;
import org.openhab.binding.dwdweatherforecast.internal.dto.MosmixStationsList;
import org.openhab.binding.dwdweatherforecast.internal.dto.MosmixStationsList.StationDetails;
import org.openhab.binding.dwdweatherforecast.internal.dto.converter.KmlToDwdWeatherDataConverter;
import org.openhab.binding.dwdweatherforecast.internal.dto.xml.Kml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class {@link DwdWeatherForecastBridgeConnection} handles the connection
 * to the DWD OpenData Portal to get the MOSMIX station list.
 * 
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
public class DwdForecastConnection {

    private final Logger logger = LoggerFactory.getLogger(DwdForecastConnection.class);

    private @Nullable MosmixStationsList stations;
    
    private final DwdForecastBridgeHandler handler;
    private final HttpClient httpClient;

    private final ExpiringCacheMap<String, String> cache;
    private final Gson json;

    public static final String MOSMIX_STATIONS_LIST_URL = "https://www.dwd.de/DE/leistungen/met_verfahren_mosmix/mosmix_stationskatalog.cfg?view=nasPublication&nn=16102";
    public static final String MOSMIX_STATION_WEATHER_FORECAST_DATA = "https://opendata.dwd.de/weather/local_forecasts/mos/MOSMIX_L/single_stations/{0}/kml/MOSMIX_L_LATEST_{0}.kmz";

    public DwdForecastConnection(DwdForecastBridgeHandler handler, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.handler = handler;

        json = new Gson();
        cache = new ExpiringCacheMap<>(
                TimeUnit.HOURS.toMillis(this.handler.getDwdForecastBridgeConfiguration().refreshInterval));

        stations = getMosmixStationsDataFromCache();
    }

    @Nullable
    public MosmixStationsList getMosmixStationsDataFromCache() {
        try {
            String stationsData = cache.putIfAbsentAndGet(MOSMIX_STATIONS_LIST_URL,
                    () -> getMosmixStationsData());

            return json.fromJson(stationsData, MosmixStationsList.class);

        } catch (Exception ex) {
            logger.debug("Error while retrieving MOSMIX Stations from DWD site. Error: {}", ex.getLocalizedMessage());

            return null;
        }
    }

    public DwdWeatherData getWeatherDataFromCache(PointType location)
            throws JsonSyntaxException, RuntimeException, IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Location for DWD Weather Forecast is missing.");
        }

        String mosmixStation = cache.putIfAbsentAndGet(location.toString(),
                () -> getNearestMosmixStation(location));

        String url = MessageFormat.format(MOSMIX_STATION_WEATHER_FORECAST_DATA, mosmixStation);

        String weatherData = cache.putIfAbsentAndGet(url, () -> {
            try {
                Kml kml = getWeatherData(url);

                KmlToDwdWeatherDataConverter converter = new KmlToDwdWeatherDataConverter(kml);

                return json.toJson(converter.convert(), DwdWeatherData.class);

            } catch (UnsupportedEncodingException ueex) {
                logger.debug("Converting Weather Data from Byte to String with wrong encoding. Exception: {}",
                        ueex.getLocalizedMessage());
            } catch (IOException ioex) {
                logger.debug(
                        "Exception while unzipping the response or copying it to byte array outputstream. Exception: {}",
                        ioex.getLocalizedMessage());
            } catch (InterruptedException | TimeoutException | ExecutionException ex) {
                logger.debug("Exception while getting response from DWD web site. Exception: {}",
                        ex.getLocalizedMessage());
            }

            return "ErrorGettingWeatherData";
        });

        if (weatherData.equals("ErrorGettingWeatherData")) {

            return new DwdWeatherData();

        } else {

            return json.fromJson(weatherData, DwdWeatherData.class);
        }
    }

    private Kml getWeatherData(String url) throws UnsupportedEncodingException, IOException,
            InterruptedException, TimeoutException, ExecutionException {

        ByteArrayInputStream response = getResponse(url);

        ZipInputStream zipResponse = new ZipInputStream(response);

        zipResponse.getNextEntry();

        ByteArrayOutputStream bArrayOutStream = new ByteArrayOutputStream();

        IOUtils.copy(zipResponse, bArrayOutStream);

        String strWeatherForecastData = new String(bArrayOutStream.toByteArray(), "ISO-8859-1");

        final QNameMap qnameMap = new QNameMap();
        qnameMap.setDefaultNamespace("http://www.opengis.net/kml/2.2");
        qnameMap.setDefaultPrefix("kml");
        qnameMap.registerMapping(new QName("http://www.opengis.net/kml/2.2", "kml", "kml"), Kml.class);

        StaxDriver driver = new StaxDriver(qnameMap);

        XStream xStream = new XStream(driver);
        xStream.setClassLoader(this.getClass().getClassLoader());
        xStream.registerConverter(new ISO8601DateConverter());
        xStream.autodetectAnnotations(true);
        // xStream.alias("kml", Kml.class);

        return (Kml) xStream.fromXML(strWeatherForecastData, new Kml());
        
    }

    @Nullable
    private String getMosmixStationsData() {

        try {

            ByteArrayInputStream stream = getResponse(MOSMIX_STATIONS_LIST_URL);

            return json.toJson(convertMosmixStationsDataToObject(stream));

        } catch (InterruptedException | TimeoutException | ExecutionException | IOException ex) {
            return null;
        }
    }

    private String getNearestMosmixStation(PointType location) {

        StationDetails nextStation = new MosmixStationsList().new StationDetails();

        if (this.stations.getMosmixStationsCounter() > 0) {

            Vector<StationDetails> stations = this.stations.getStationDetails();
            Iterator<StationDetails> iter = stations.iterator();
            StationDetails station;
            double smallestDistance = 15000000;

            while (iter.hasNext()) {
                station = iter.next();

                DecimalType distance = location.distanceFrom(
                        new PointType(new DecimalType(station.getNb()), new DecimalType(station.getEl())));

                if (distance.doubleValue() < smallestDistance) {
                    smallestDistance = distance.doubleValue();
                    nextStation = station;
                }
            }
        }
        
        return nextStation.getId();

    }

    @Nullable
    private MosmixStationsList convertMosmixStationsDataToObject(ByteArrayInputStream stream)
            throws UnsupportedEncodingException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "ISO-8859-1"));

        String line;

        this.stations = new MosmixStationsList();

        while ((line = reader.readLine()) != null) {

            MosmixStationsList.StationDetails station = stations.new StationDetails();

            if (line.length() == 76) {
                try {
                    station.setClu(Integer.parseInt(line.substring(0, 5).trim()));
                    station.setCofX(line.substring(6, 11).trim());
                    station.setId(line.substring(12, 17).trim());
                    station.setICAO(line.substring(18, 22).trim());
                    station.setName(line.substring(23, 43).trim());
                    station.setNb(Double.parseDouble(line.substring(44, 50).trim()));
                    station.setEl(Double.parseDouble(line.substring(51, 58).trim()));
                    station.setElev(Integer.parseInt(line.substring(59, 64).trim()));
                    station.setHmod_h(line.substring(65, 71).trim());
                    station.setType(line.substring(72, 76).trim());

                    this.stations.addStationDetail(station);

                    this.stations.increaseStationsCounter();

                    // System.out.println(line);
                } catch (NumberFormatException ex) {
                    continue;
                }
            }
        }

        return this.stations;
    }

    public int getMosmixStationsCounter() {
        return stations.getMosmixStationsCounter();
    }

    public Vector<StationDetails> getMosmixStationDetails() {
        return stations.getStationDetails();
    }

    private ByteArrayInputStream getResponse(String urlString)
            throws InterruptedException, TimeoutException, ExecutionException {

        ContentResponse response = httpClient.newRequest(urlString).timeout(10, TimeUnit.SECONDS).send();

        return new ByteArrayInputStream(response.getContent());
    }

}
