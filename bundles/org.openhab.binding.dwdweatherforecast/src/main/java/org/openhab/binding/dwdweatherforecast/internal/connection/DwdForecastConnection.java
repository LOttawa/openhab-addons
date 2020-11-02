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
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.ZipInputStream;

import javax.xml.namespace.QName;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import org.apache.commons.io.IOUtils;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.smarthome.core.cache.ExpiringCacheMap;
import org.eclipse.smarthome.core.library.types.PointType;
import org.openhab.binding.dwdweatherforecast.internal.config.DwdForecastBridgeHandlerConfiguration;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdForecastBridgeHandler;
import org.openhab.binding.dwdweatherforecast.internal.model.DwdWeatherData;
import org.openhab.binding.dwdweatherforecast.internal.model.MosmixStationsList;
import org.openhab.binding.dwdweatherforecast.internal.model.MosmixStationsList.StationDetails;
import org.openhab.binding.dwdweatherforecast.internal.model.xml.Kml;
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

    private MosmixStationsList stations;

    private final DwdForecastBridgeHandler handler;
    private final HttpClient httpClient;

    private final ExpiringCacheMap<String, String> cache;

    public static final String MOSMIX_STATIONS_LIST_URL = "https://www.dwd.de/DE/leistungen/met_verfahren_mosmix/mosmix_stationskatalog.cfg?view=nasPublication&nn=16102";
    public static final String MOSMIX_STATION_WEATHER_FORECAST_DATA = "https://opendata.dwd.de/weather/local_forecasts/mos/MOSMIX_L/single_stations/${0}/kml/MOSMIX_L_LATEST_${0}.kmz";

    public DwdForecastConnection(DwdForecastBridgeHandler handler, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.handler = handler;

        DwdForecastBridgeHandlerConfiguration config = handler.getDwdForecastBridgeConfiguration();
        this.cache = new ExpiringCacheMap<>(TimeUnit.HOURS.toMillis(config.refreshInterval));
    }

    public void getMosmixStationsData() {
        try {
            getMosmixStationsDataFromCache();
        } catch (Exception ex) {
            logger.debug("Error while retrieving MOSMIX Stations from DWD site. Error: " + ex.getLocalizedMessage());
        }
    }

    public DwdWeatherData getWeatherData(PointType location)
            throws JsonSyntaxException, RuntimeException, IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("Location for DWD Weather Forecast is missing.");
        }

        String mosmixStation = getNearestMosmixStation(location);

        String url = String.format(MOSMIX_STATION_WEATHER_FORECAST_DATA, mosmixStation);

        return getWeatherDataFromCache(url);

    }

    private DwdWeatherData getWeatherDataFromCache(String url) {

        String content = cache.get(url);

        if (content == null) {
            try {
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
                xStream.autodetectAnnotations(true);

                Object kmlObject = xStream.fromXML(strWeatherForecastData);

                Kml kml = (Kml) kmlObject;

                Gson json = new Gson();

                content = json.toJson(kml, Kml.class);

                cache.putValue(url, content);

            } catch (UnsupportedEncodingException ueex) {
                logger.debug("Converting Weather Data from Byte to String with wrong encoding. Exception: "
                        + ueex.getLocalizedMessage());
            } catch (IOException ioex) {
                logger.debug(
                        "Exception while unzipping the response or copying it to byte array outputstream. Exception: "
                                + ioex.getLocalizedMessage());
            } catch (InterruptedException | TimeoutException | ExecutionException ex) {
                logger.debug(
                        "Exception while getting response from DWD web site. Exception: " + ex.getLocalizedMessage());
            }
        }

        return getDwdWeatherDataFromCacheContent(content);
    }

    private DwdWeatherData getDwdWeatherDataFromCacheContent(String content) {
        return null;
    }

    private MosmixStationsList getMosmixStationsDataFromCache() {

        Gson gson = new Gson();

        String content = cache.get(MOSMIX_STATIONS_LIST_URL);

        if (content == null) {
            try {


                ByteArrayInputStream stream = getResponse(MOSMIX_STATIONS_LIST_URL);

                content = gson.toJson(convertMosmixStationsDataToObject(stream));

                cache.putValue(MOSMIX_STATIONS_LIST_URL, content);

            } catch (InterruptedException | TimeoutException | ExecutionException | IOException ex) {

            }
        }
        
        return gson.fromJson(content, MosmixStationsList.class);
    }

    private String getNearestMosmixStation(PointType location) {

        // Map<String, Object> values = new HashMap<String, Object>();
        // values.put("0", this.nextStation.getId());

        // String urlString = StringUtils.format(DWDLocalWeatherConstants.MOSMIX_STATION_WEATHER_FORECAST_DATA, values);

        return "";
    }

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
        return this.stations.getMosmixStationsCounter();
    }

    public Vector<StationDetails> getMosmixStationDetails() {
        return this.stations.getStationDetails();
    }

    private ByteArrayInputStream getResponse(String urlString)
            throws InterruptedException, TimeoutException, ExecutionException {

        ContentResponse response = this.httpClient.newRequest(urlString).timeout(10, TimeUnit.SECONDS).send();

        System.out.println("Http Status: " + response.getStatus());

        return new ByteArrayInputStream(response.getContent());
    }

}
