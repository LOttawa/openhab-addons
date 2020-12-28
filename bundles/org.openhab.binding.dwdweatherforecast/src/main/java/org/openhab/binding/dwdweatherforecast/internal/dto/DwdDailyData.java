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
package org.openhab.binding.dwdweatherforecast.internal.dto;

import java.time.ZonedDateTime;

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
public class DwdDailyData {

    private long timestamp;
    private NightForecast nightForecast;
    private DayForecast dayForecast;

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public NightForecast getNightForecast() {
        return this.nightForecast;
    }

    public void setNightForecast(NightForecast nightForecast) {
        this.nightForecast = nightForecast;
    }

    public DayForecast getDayForecast() {
        return this.dayForecast;
    }

    public void setDayForecast(DayForecast dayForecast) {
        this.dayForecast = dayForecast;
    }

    public class DayForecast extends ForecastData {

        private long hours = 18;

        public DayForecast(ZonedDateTime date) {

            setTimestamp(date.plusHours(hours).toInstant().toEpochMilli());
        }
    };

    public class NightForecast extends ForecastData {

        private long hours = 6;

        public NightForecast(ZonedDateTime date) {

            setTimestamp(date.plusHours(hours).toInstant().toEpochMilli());
        }
    };
    
    public abstract class ForecastData implements ForecastDataIntf {

        private long timestamp;
        private double minTemperature;
        private double maxTemperature;
        private int windDirection;
        private double windSpeed;
        private double gustSpeed;
        private double pressure;
        private long visibility;
        private double precipitation;
        private int cloudCover;
        private String significantWeather;
        private String swIcon;

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public double getMinTemperature() {
            return minTemperature;
        }

        public void setMinTemperature(double minTemperature) {
            this.minTemperature = minTemperature;
        }

        public double getMaxTemperature() {
            return maxTemperature;
        }

        public void setMaxTemperature(double maxTemperature) {
            this.maxTemperature = maxTemperature;
        }

        public int getWindDirection() {
            return windDirection;
        }

        public void setWindDirection(int windDirection) {
            this.windDirection = windDirection;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public double getGustSpeed() {
            return gustSpeed;
        }

        public void setGustSpeed(double gustSpeed) {
            this.gustSpeed = gustSpeed;
        }
        
        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public long getVisibility() {
            return visibility;
        }

        public void setVisibility(long visibility) {
            this.visibility = visibility;
        }

        public double getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(double precipitation) {
            this.precipitation = precipitation;
        }

        public int getCloudCover() {
            return cloudCover;
        }

        public void setCloudCover(int cloudCover) {
            this.cloudCover = cloudCover;
        }

        public String getSignificantWeather() {
            return significantWeather;
        }

        public void setSignificantWeather(String significantWeather) {
            this.significantWeather = significantWeather;
        }

        public String getSWIcon() {
            return swIcon;
        }

        public void setSWIcon(String swIcon) {
            this.swIcon = swIcon;
        }
    }
    
    public interface ForecastDataIntf {

        public long getTimestamp();

        public void setTimestamp(long timestamp);

        public double getMinTemperature();

        public void setMinTemperature(double minTemperature);

        public double getMaxTemperature();

        public void setMaxTemperature(double maxTemperature);

        public int getWindDirection();

        public void setWindDirection(int windDirection);

        public double getWindSpeed();

        public void setWindSpeed(double windSpeed);

        public double getGustSpeed();

        public void setGustSpeed(double gustSpeed);
        
        public double getPressure();

        public void setPressure(double pressure);

        public long getVisibility();

        public void setVisibility(long visibility);

        public double getPrecipitation();

        public void setPrecipitation(double precipitation);

        public int getCloudCover();

        public void setCloudCover(int cloudCover);

        public String getSignificantWeather();

        public void setSignificantWeather(String significantWeather);

        public String getSWIcon();

        public void setSWIcon(String swIcon);
    }
}
