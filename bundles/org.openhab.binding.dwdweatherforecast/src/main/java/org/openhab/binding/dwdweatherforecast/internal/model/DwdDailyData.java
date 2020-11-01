package org.openhab.binding.dwdweatherforecast.internal.model;

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

public class DwdDailyData {

    private @Nullable List<DailyData> data;

    public @Nullable List<DailyData> getData() {
        return data;
    }

    public void setData(@Nullable List<DailyData> data) {
        this.data = data;
    }

    public class DailyData {

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
}
