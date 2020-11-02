package org.openhab.binding.dwdweatherforecast.internal.model;

public class DwdDailyData {

    private int timestamp;
    private double minTemperature;
    private double maxTemperature;

    public int getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public double getMinTemperature() {
        return this.minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return this.maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
