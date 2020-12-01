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
package org.openhab.binding.dwdweatherforecast.internal.handler;

import static org.openhab.binding.dwdweatherforecast.internal.DwdForecastBindingConstants.*;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseBridgeHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
import org.openhab.binding.dwdweatherforecast.internal.config.DwdForecastBridgeHandlerConfiguration;
import org.openhab.binding.dwdweatherforecast.internal.connection.DwdForecastConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link DwdForecastBridgeHandler} is responsible for handling commands, which are
 * sent to one of the Things.
 *
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
public class DwdForecastBridgeHandler extends BaseBridgeHandler {

    private final Logger logger = LoggerFactory.getLogger(DwdForecastBridgeHandler.class);

    public static final Set<ThingTypeUID> SUPPORTED_THING_TYPES = Collections.singleton(THING_TYPE_DWD_FORECAST_BRIDGE);

    private static final long INITIAL_DELAY_IN_SECONDS = 30;

    private @Nullable ScheduledFuture<?> refreshJob; 

    private HttpClient httpClient;
    private @Nullable DwdForecastConnection connection;

    private DwdForecastBridgeHandlerConfiguration config;

    public DwdForecastBridgeHandler(Bridge bridge, HttpClient httpClient) {
        super(bridge);
        this.httpClient = httpClient;

        this.config = getConfigAs(DwdForecastBridgeHandlerConfiguration.class);
    }

    @Override
    public void initialize() {
        logger.debug("Start initializing DWD Weather Forecast Bridge handler '{}'.", getThing().getUID());

        boolean validConfig = true;

        // Validate Configuration Parameter
        int refreshInterval = config.refreshInterval;
        if (refreshInterval < 1) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
                    "@text/offline.error-conf-bridge-refreshInterval");
            validConfig = false;
        }

        if (validConfig) {

            this.connection = new DwdForecastConnection(this, httpClient);

            updateStatus(ThingStatus.UNKNOWN);

            ScheduledFuture<?> refreshJob = this.refreshJob;
            if (refreshJob == null) {
                this.refreshJob = scheduler.scheduleWithFixedDelay(this::updateThings, INITIAL_DELAY_IN_SECONDS,
                        TimeUnit.HOURS.toSeconds(refreshInterval), TimeUnit.SECONDS);
            }

        }
    }

    @Override
    public void dispose() {
        logger.debug("Dispose DWD Forecast Bridge handler '{}'.", getThing().getUID());
        ScheduledFuture<?> localRefreshJob = refreshJob;
        if (localRefreshJob != null && !localRefreshJob.isCancelled()) {
            logger.debug("Stop refresh job.");
            if (localRefreshJob.cancel(true)) {
                refreshJob = null;
            }
        }
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (command instanceof RefreshType) {
            scheduler.schedule(this::updateThings, INITIAL_DELAY_IN_SECONDS, TimeUnit.SECONDS);
        } else {
            logger.debug("The DWD Weather Forecast binding is a read-only binding and cannot handle command '{}'.",
                    command);
        }
    }
    
    @Override
    public void childHandlerInitialized(ThingHandler childHandler, Thing childThing) {
        scheduler.schedule(() -> {
            updateThing((DwdForecastHandler) childHandler, childThing);
            determineBridgeStatus();
        }, INITIAL_DELAY_IN_SECONDS, TimeUnit.SECONDS);
    }

    @Override
    public void childHandlerDisposed(ThingHandler childHandler, Thing childThing) {
        determineBridgeStatus();
    }

    private void determineBridgeStatus() {
        ThingStatus status = ThingStatus.OFFLINE;
        for (Thing thing : getThing().getThings()) {
            if (ThingStatus.ONLINE.equals(thing.getStatus())) {
                status = ThingStatus.ONLINE;
                break;
            }
        }
        updateStatus(status);
    }

    private void updateThings() {
        ThingStatus status = ThingStatus.OFFLINE;
        for (Thing thing : this.getThing().getThings()) {
            if (ThingStatus.ONLINE.equals(updateThing((DwdForecastHandler) thing.getHandler(), thing))) {
                status = ThingStatus.ONLINE;
            }
        }
        updateStatus(status);
    }

    private ThingStatus updateThing(DwdForecastHandler handler, Thing thing) {
        if (handler != null && connection != null) {
            handler.updateData(connection);
            return thing.getStatus();
        } else {
            logger.debug("Cannot update weather data of thing '{}' as location handler is null.", thing.getUID());
            return ThingStatus.OFFLINE;
        }
     }

    public DwdForecastBridgeHandlerConfiguration getDwdForecastBridgeConfiguration() {
        return this.config;
    }
}
