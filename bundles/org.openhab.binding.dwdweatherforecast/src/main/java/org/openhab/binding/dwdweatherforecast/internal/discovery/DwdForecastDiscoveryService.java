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
package org.openhab.binding.dwdweatherforecast.internal.discovery;

import static org.openhab.binding.dwdweatherforecast.internal.DwdForecastBindingConstants.*;

import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder;
import org.eclipse.smarthome.core.i18n.LocaleProvider;
import org.eclipse.smarthome.core.i18n.LocationProvider;
import org.eclipse.smarthome.core.i18n.TranslationProvider;
import org.eclipse.smarthome.core.library.types.PointType;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdForecastBridgeHandler;
import org.openhab.binding.dwdweatherforecast.internal.handler.DwdForecastHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link DDwdForecastDiscoveryService} is responsible for discovering
 * new things with new location
 *
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
public class DwdForecastDiscoveryService extends AbstractDiscoveryService {

    private final Logger logger = LoggerFactory.getLogger(DwdForecastDiscoveryService.class);

    private static final int DISCOVERY_TIMEOUT = 2;
    private static final int DISCOVERY_INTERVAL_SECONDS = 60;
    private @Nullable ScheduledFuture<?> discoveryJob;
    private final LocationProvider locationProvider;
    private final DwdForecastBridgeHandler bridgeHandler;
    private Vector<PointType> currentLocations;

    public DwdForecastDiscoveryService(DwdForecastBridgeHandler bridgeHandler, LocationProvider locationProvider,
            LocaleProvider localeProvider, TranslationProvider i18nProvider) {
        super(DwdForecastHandler.SUPPORTED_THING_TYPES, DISCOVERY_TIMEOUT);
        this.bridgeHandler = bridgeHandler;
        this.i18nProvider = i18nProvider;
        this.localeProvider = localeProvider;
        this.locationProvider = locationProvider;
        currentLocations = new Vector<PointType>();

        activate(null);
    }

    @Override
    public void deactivate() {
        super.deactivate();
    }

    @Override
    protected void startBackgroundDiscovery() {
        if (discoveryJob == null || discoveryJob.isCancelled()) {
            logger.debug("Start DWD Forecast Location background discovery job at interval {} s.",
                    DISCOVERY_INTERVAL_SECONDS);
            discoveryJob = scheduler.scheduleWithFixedDelay(this::scanForNewLocalForecastLocation, 0, DISCOVERY_INTERVAL_SECONDS,
                    TimeUnit.SECONDS);
        }
    }

    @Override
    protected void stopBackgroundDiscovery() {
        if (discoveryJob != null && !discoveryJob.isCancelled()) {
            logger.debug("Stop DWD Forecast Location background discovery job.");
            if (discoveryJob.cancel(true)) {
                discoveryJob = null;
            }
        }
    }

    @Override
    protected void startScan() {
        logger.debug("Started DWD Forecast Thing Discovery scan manually to search for new locations.");
        scanForNewLocalForecastLocation();

    }

    @Override
    protected synchronized void stopScan() {
        logger.debug("Stopped DWD Forecast Thing Discovery scan manually.");
        super.stopScan();
    }

    private void scanForNewLocalForecastLocation() {
        PointType newLocation = this.locationProvider.getLocation();

        if (newLocation == null) {
            logger.debug("No Location given. No Discovery results will be determined.");
        } else if (currentLocations.size() == 0 || !currentLocations.contains(newLocation)) {
            createResults(newLocation);
            currentLocations.add(newLocation);
        } else {
            logger.debug("Location already in Results, therefore no new results will created");
        }
    }

    private void createResults(PointType location) {
        String locationString = location.toFullString();
        String locationIndex = "loc";

        int counter = currentLocations.size();
        locationIndex = locationIndex.concat(String.valueOf(counter + 1));
        ThingUID bridgeUID = this.bridgeHandler.getThing().getUID();
        createDwdLocaleWeatherForecastResult(bridgeUID, locationString, locationIndex);
    }

    private void createDwdLocaleWeatherForecastResult(ThingUID bridgeUID, String locationString, String locationIndex) {
        thingDiscovered(
                DiscoveryResultBuilder.create(new ThingUID(THING_TYPE_DWD_LOCAL_FORECAST, bridgeUID, locationIndex))
                        .withLabel("Local DWD Weather and Forecast").withProperty(CONFIG_LOCATION, locationString)
                        .withRepresentationProperty(CONFIG_LOCATION).withBridge(bridgeUID).build());
    }
}