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

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
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
