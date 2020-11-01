package org.openhab.binding.dwdweatherforecast.internal.model;

public class DwdCurrentData {

    private int timestamp;
    private double temperature;

    public int getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
