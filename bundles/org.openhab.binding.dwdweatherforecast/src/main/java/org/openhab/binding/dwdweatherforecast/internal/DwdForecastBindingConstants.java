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
package org.openhab.binding.dwdweatherforecast.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.type.ChannelGroupTypeUID;

/**
 * The {@link DwdForecastBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
public class DwdForecastBindingConstants {

    private static final String BINDING_ID = "dwdweatherforecast";

    public static final String CONFIG_LOCATION = "location";

    // Thing Type for DWD Weather Forecast Bridge
    public static final ThingTypeUID THING_TYPE_DWD_FORECAST_BRIDGE = new ThingTypeUID(BINDING_ID, "dwd-weather-forecast-bridge");
    // Thing Type for Local Forecast Thing
    public static final ThingTypeUID THING_TYPE_DWD_LOCAL_FORECAST = new ThingTypeUID(BINDING_ID, "local-forecast");

    // Channel group types
    public static final ChannelGroupTypeUID CHANNEL_GROUP_TYPE_DAILY_FORECAST = new ChannelGroupTypeUID(BINDING_ID,
            "dailyForecast");

    // List of all channel groups
    public static final String CHANNEL_GROUP_CURRENT_WEATHER = "current";
    public static final String CHANNEL_GROUP_FORECAST_TOMORROW = "forecastTomorrow";

    // List of all Channels
    public static final String CHANNEL_TIME_STAMP = "time-stamp";
    public static final String CHANNEL_TEMPERATURE = "temperature";
    public static final String CHANNEL_MAX_TEMPERATURE = "max-temperature";
    public static final String CHANNEL_MIN_TEMPERATURE = "min-temperature";
    public static final String CHANNEL_WIND_DIRECTION = "wind-direction";
    public static final String CHANNEL_WIND_SPEED = "wind-speed";
    public static final String CHANNEL_GUST_SPEED = "gust-speed";
    public static final String CHANNEL_PRESSURE = "pressure";
    public static final String CHANNEL_VISIBILITY = "visibility";
    public static final String CHANNEL_PRECIPITATION = "precipitation";
    public static final String CHANNEL_CLOUD_COVER = "cloud-cover";
    public static final String CHANNEL_SIGNIFICANT_WEATHER = "significant-weather";
    public static final String CHANNEL_SW_ICON = "sw-icon";

    public static final String EVENT_START = "START";
}
