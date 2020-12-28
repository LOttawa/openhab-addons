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
package org.openhab.binding.dwdweatherforecast.internal.config;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdForecastHandler;

/**
 * The {@link DwdForecastHandlerConfiguration} class contains fields mapping thing configuration parameters
 * of the {@link DwdForecastHandler}.
 *
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
public class DwdForecastHandlerConfiguration {
    
    public @NonNullByDefault({}) String location;
    public int refreshInterval = 1;
    public int forecastDays;

}
