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
package org.openhab.binding.dwdweatherforecast.internal.dto.converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhab.binding.dwdweatherforecast.internal.dto.DwdCurrentData;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdDailyData;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdWeatherData;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdDailyData.DayForecast;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdDailyData.ForecastData;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdDailyData.NightForecast;
import org.openhab.binding.dwdweatherforecast.internal.dto.xml.Forecast;
import org.openhab.binding.dwdweatherforecast.internal.dto.xml.Kml;

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
public class KmlToDwdWeatherDataConverter {

    private final Kml kml;
    private List<Date> forecastTimestamps;
    private List<Forecast> forecastData;

    public KmlToDwdWeatherDataConverter(Kml kml) {
        this.kml = kml;

        setForecastTimestamps();
        setForecastData();
    }

    public DwdWeatherData convert() {

        DwdWeatherData weatherData = new DwdWeatherData();

        mapCurrentData(weatherData);

        mapDailyData(weatherData);

        return weatherData;
    }

    private void mapCurrentData(DwdWeatherData weatherData) {
        DwdCurrentData currentData = new DwdCurrentData();

        Date nextFullHour = getIndexOfNextFullHourEntry();

        if (nextFullHour != null) {
            currentData.setTimestamp(nextFullHour.getTime());
        
            getCurrentForecastDataByTime(currentData);

            weatherData.setCurrentData(currentData);
            
        } else {
            // throw ValueNotFoundException("Value for next full Hour not found in Forecast Timestamp.")
        }
    }

    private void mapDailyData(DwdWeatherData weatherData) {
        List<DwdDailyData> dailyDataList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            dailyDataList.add(getDailyForecastData(i));
        }

        weatherData.setDailyData(dailyDataList);
    }

    private DwdDailyData getDailyForecastData(int i) {

        ZoneId zone = ZoneId.of("UTC");
        LocalDate now = LocalDate.now(zone);

        ZonedDateTime dailyDate = now.plusDays(i).atStartOfDay(zone);

        DwdDailyData dailyData = new DwdDailyData();

        dailyData.setTimestamp(dailyDate.toInstant().toEpochMilli());

        DayForecast dayForecast = dailyData.new DayForecast(dailyDate);
        getDailyForecastDataByTime(dayForecast);
        dailyData.setDayForecast(dayForecast);

        NightForecast nightForecast = dailyData.new NightForecast(dailyDate);
        getDailyForecastDataByTime(nightForecast);
        dailyData.setNightForecast(nightForecast);

        return dailyData;
    }

    private void getDailyForecastDataByTime(ForecastData dailyData) {

        double minTemperature = Double.parseDouble(getForecastValueByTypeAndTime("TN", dailyData.getTimestamp()));
        dailyData.setMinTemperature(minTemperature);

        double maxTemperature = Double.parseDouble(getForecastValueByTypeAndTime("TX", dailyData.getTimestamp()));
        dailyData.setMaxTemperature(maxTemperature);

        int windDirection = Integer.parseInt(getForecastValueByTypeAndTime("DD", dailyData.getTimestamp()));
        dailyData.setWindDirection(windDirection);

        double windSpeed = Double.parseDouble(getForecastValueByTypeAndTime("FF", dailyData.getTimestamp()));
        dailyData.setWindSpeed(windSpeed);

        double gustSpeed = Double.parseDouble(getForecastValueByTypeAndTime("FXh", dailyData.getTimestamp()));
        dailyData.setGustSpeed(gustSpeed);

        double pressure = Double.parseDouble(getForecastValueByTypeAndTime("PPPP", dailyData.getTimestamp()));
        dailyData.setPressure(pressure);

        long visibility = Long.parseLong(getForecastValueByTypeAndTime("VV", dailyData.getTimestamp()));
        dailyData.setVisibility(visibility);

        double precipitation = Double.parseDouble(getForecastValueByTypeAndTime("RRhc", dailyData.getTimestamp()));
        dailyData.setPrecipitation(precipitation);

        int cloudCover = Integer.parseInt(getForecastValueByTypeAndTime("Neff", dailyData.getTimestamp()));
        dailyData.setCloudCover(cloudCover);

        // Parser für Signifikantes Wetter schreiben... Int-Wert in String konvertieren
        //int significantWeather = Integer.parseInt(getForecastValueByTypeAndTime("WPch1", dailyData.getTimestamp()));
        //dailyData.setSignificantWeather(significantWeather);

    }
    
    private void getCurrentForecastDataByTime(DwdCurrentData currentData) {

        double currTemperature = Double.parseDouble(getForecastValueByTypeAndTime("TTT", currentData.getTimestamp()));
        currentData.setTemperature(currTemperature);

        int windDirection = Integer.parseInt(getForecastValueByTypeAndTime("DD", currentData.getTimestamp()));
        currentData.setWindDirection(windDirection);

        double windSpeed = Double.parseDouble(getForecastValueByTypeAndTime("FF", currentData.getTimestamp()));
        currentData.setWindSpeed(windSpeed);

        double gustSpeed = Double.parseDouble(getForecastValueByTypeAndTime("FX1", currentData.getTimestamp()));
        currentData.setGustSpeed(gustSpeed);

        double pressure = Double.parseDouble(getForecastValueByTypeAndTime("PPPP", currentData.getTimestamp()));
        currentData.setPressure(pressure);

        long visibility = Long.parseLong(getForecastValueByTypeAndTime("VV", currentData.getTimestamp()));
        currentData.setVisibility(visibility);

        double precipitation = Double.parseDouble(getForecastValueByTypeAndTime("RR1c", currentData.getTimestamp()));
        currentData.setPrecipitation(precipitation);

        int cloudCover = Integer.parseInt(getForecastValueByTypeAndTime("Neff", currentData.getTimestamp()));
        currentData.setCloudCover(cloudCover);

        // Parser für Signifikantes Wetter schreiben... Int-Wert in String konvertieren
        //int significantWeather = Integer.parseInt(getForecastValueByTypeAndTime("ww", currentData.getTimestamp()));
        //currentData.setSignificantWeather(significantWeather);

    }

    private Date getIndexOfNextFullHourEntry() {
        Date nextFullHour = null;

        Iterator<Date> iter = forecastTimestamps.iterator();
        while (iter.hasNext()) {
            if ((nextFullHour = iter.next()).after(new Date())) {
                break;
            }
        }

        return nextFullHour;
    }

    private String getForecastValueByTypeAndTime(String type, long timeStamp) {

        int index = forecastTimestamps.indexOf(new Date(timeStamp));

        List<String> values = getForecastValuesByType(type);

        return values.get(index);
    }

    private List<String> getForecastValuesByType(String type) {

        boolean notfound = true;
        Iterator<Forecast> iter = forecastData.iterator();
        String value = "";
        while (iter.hasNext() && notfound) {
            Forecast data = iter.next();
            if (data.getElementName().equals(type)) {
                notfound = false;
                value = data.getValue();
            }
        }
        return (List<String>) Arrays.asList(value.replaceAll("\\s{2,}", " ").trim().split("\\s+"));
    }

    private void setForecastData() {
        forecastData = kml.getDocument().getPlacemark().getExtendedData().getForecast();
    }

    private void setForecastTimestamps() {
        forecastTimestamps = kml.getDocument().getExtendedData().getProductDefinition().getForecastTimeSteps()
                .getTimeStep();
    }

}
