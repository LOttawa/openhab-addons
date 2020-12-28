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
package org.openhab.binding.dwdweatherforecast.internal.dto.parser;

import java.util.HashMap;

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
public class SignificantWeatherParser {
    
    private static HashMap<String, String> significatWeatherMap;

    static {
        significatWeatherMap = new HashMap<>();

        significatWeatherMap.put("00", "Effektive Wolkendecke weniger als 1/8");
        significatWeatherMap.put("01", "Effektive Wolkendecke zwischen 1/8 und 4.5/8");
        significatWeatherMap.put("02", "Effektive Wolkendecke zwischen 4.6/8 und 6/8");
        significatWeatherMap.put("03", "Effektive Wolkendecke mindestens 7/8");
        significatWeatherMap.put("45", "Nebel, Himmel nicht erkennbar");
        significatWeatherMap.put("49", "ENebel mit Reifansatz, Himmel nicht erkennbar, unverändert");
        significatWeatherMap.put("61", "durchgehend leichter Regen");
        significatWeatherMap.put("63", "durchgehend mäßiger Regen");
        significatWeatherMap.put("65", "durchgehend starker Regen");
        significatWeatherMap.put("51", "durchgehend leichter Sprühregen");
        significatWeatherMap.put("53", "durchgehend mäßiger Sprühregen");
        significatWeatherMap.put("55", "durchgehend starker Sprühregen");
        significatWeatherMap.put("68", "leichter Schneeregen");
        significatWeatherMap.put("69", "mäßger oder starker Schneeregen");
        significatWeatherMap.put("71", "durchgehend leichter Schneefall");
        significatWeatherMap.put("73", "durchgehend mäßiger Schneefall");
        significatWeatherMap.put("75", "durchgehend starker Schneefall");
        significatWeatherMap.put("80", "leichter Regenschauer");
        significatWeatherMap.put("81", "mäßiger oder starker Regenschauer");
        significatWeatherMap.put("82", "äußerst heftiger Regenschauer");
        significatWeatherMap.put("83", "leichter Schneeregenschauer");
        significatWeatherMap.put("84", "mäßiger oder starker Schneeregenschauer");
        significatWeatherMap.put("85", "leichter Schneeschauer");
        significatWeatherMap.put("86", "mäßiger bis starker Schneeschauer");
        significatWeatherMap.put("66", "leichter gefrierender Regen");
        significatWeatherMap.put("67", "mäßiger bis starker gefrierender Regen");
        significatWeatherMap.put("56", "leichter gefrierender Sprühregen");
        significatWeatherMap.put("57", "mäßiger oder starker gefrierender Sprühregen");
        significatWeatherMap.put("95", "leichtes oder mäßiges Gewitter mit Regen oder Schnee");
    }

    public static String parseValue(String value) {

        return significatWeatherMap.get(value);
    }
}
