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

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
public class DwdCurrentData {

    private long timestamp;
    private double temperature;
    private double windDirection;
    private double windSpeed;
    private double gustSpeed;
    private double pressure;
    private long visibility;
    private double precipitation;
    private int cloudCover;
    private String significantWeather;
    private String swIcon;

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
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
