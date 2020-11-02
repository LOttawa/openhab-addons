package org.openhab.binding.dwdweatherforecast.internal.model;

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

public class DwdWeatherData {
    
    private String location;
    private DwdCurrentData currentData;
    private @Nullable List<DwdDailyData> dailyData;

    public @Nullable List<DwdDailyData> getDailyData() {
        return dailyData;
    }

    public void setDailyData(@Nullable List<DwdDailyData> dailyData) {
        this.dailyData = dailyData;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DwdCurrentData getCurrentData() {
        return this.currentData;
    }

    public void setCurrentData(DwdCurrentData currentData) {
        this.currentData = currentData;
    }

}
