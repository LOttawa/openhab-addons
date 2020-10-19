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
package org.openhab.binding.dwdweatherforecast.internal.factory;

import static org.openhab.binding.dwdweatherforecast.internal.DwdWeatherForecastBindingConstants.*;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.smarthome.core.i18n.LocaleProvider;
import org.eclipse.smarthome.core.i18n.LocationProvider;
import org.eclipse.smarthome.core.i18n.TranslationProvider;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerFactory;
import org.eclipse.smarthome.io.net.http.HttpClientFactory;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdForecastBridgeHandler;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdLocalForecastHandler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The {@link DwdWeatherForecastHandlerFactory} is responsible for creating
 * things and thing handlers.
 *
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
@Component(configurationPid = "binding.dwdweatherforecast", service = ThingHandlerFactory.class)
public class DwdWeatherForecastHandlerFactory extends BaseThingHandlerFactory {

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections
            .unmodifiableSet(Stream.concat(DwdForecastBridgeHandler.SUPPORTED_THING_TYPES.stream(),
                    DwdLocalForecastHandler.SUPPORTED_THING_TYPES.stream()).collect(Collectors.toSet()));

    private final HttpClient httpClient;
    private final LocationProvider locationProvider;
    private final LocaleProvider localeProvider;
    private final TranslationProvider translationProvider;

    @Activate
    public DwdWeatherForecastHandlerFactory(final @Reference HttpClientFactory httpClientFactory,
            final @Reference LocationProvider locationProvider, final @Reference LocaleProvider localeProvider, final @Reference TranslationProvider translationProvider) {
        this.httpClient = httpClientFactory.getCommonHttpClient();
        this.localeProvider = localeProvider;
        this.locationProvider = locationProvider;
        this.translationProvider = translationProvider;
    }

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected @Nullable ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (THING_TYPE_DWD_FORECAST_BRIDGE.equals(thingTypeUID)) {
            return new DwdForecastBridgeHandler((Bridge) thing, this.httpClient);
        } else if (THING_TYPE_DWD_LOCAL_FORECAST.equals(thingTypeUID)) {
            return new DwdLocalForecastHandler(thing, this.httpClient);
        }

        return null;
    }
}
