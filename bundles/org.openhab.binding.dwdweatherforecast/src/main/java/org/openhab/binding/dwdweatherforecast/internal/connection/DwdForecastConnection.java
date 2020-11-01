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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.smarthome.core.cache.ExpiringCacheMap;
import org.openhab.binding.dwdweatherforecast.internal.config.DwdForecastBridgeHandlerConfiguration;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdForecastBridgeHandler;
import org.openhab.binding.dwdweatherforecast.internal.model.MosmixStationsList;
import org.openhab.binding.dwdweatherforecast.internal.model.MosmixStationsList.StationDetails;
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

    public DwdForecastConnection(DwdForecastBridgeHandler handler, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.handler = handler;

        DwdForecastBridgeHandlerConfiguration config = handler.getDwdForecastBridgeConfiguration();
        cache = new ExpiringCacheMap<>(TimeUnit.HOURS.toMillis(config.refreshInterval));
    }

    public String getMosmixStationsData() throws InterruptedException, TimeoutException, ExecutionException,
            UnsupportedEncodingException, IOException {
        Gson gson = new Gson();

        ByteArrayInputStream stream = sendRequest(MOSMIX_STATIONS_LIST_URL);

        return gson.toJson(convertMosmixStationsDataToObject(stream));
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

    private ByteArrayInputStream sendRequest(String urlString)
            throws InterruptedException, TimeoutException, ExecutionException {

        ContentResponse response = this.httpClient.newRequest(urlString).timeout(10, TimeUnit.SECONDS).send();

        System.out.println("Http Status: " + response.getStatus());

        return new ByteArrayInputStream(response.getContent());
    }

}
