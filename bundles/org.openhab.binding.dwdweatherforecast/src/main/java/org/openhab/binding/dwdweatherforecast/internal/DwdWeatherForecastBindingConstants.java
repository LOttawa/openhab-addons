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

/**
 * The {@link DwdWeatherForecastBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
public class DwdWeatherForecastBindingConstants {

    private static final String BINDING_ID = "dwdweatherforecast";

    // Thing Type for DWD Weather Forecast Bridge
    public static final ThingTypeUID THING_TYPE_DWD_FORECAST_BRIDGE = new ThingTypeUID(BINDING_ID, "dwd-weather-forecast-bridge");
    // Thing Type for Local Forecast Thing
    public static final ThingTypeUID THING_TYPE_DWD_LOCAL_FORECAST = new ThingTypeUID(BINDING_ID, "local-forecast");

    // List of all Channels
    public static final String CHANNEL_MAX_TEMPERATURE = "max-temperature";
}
