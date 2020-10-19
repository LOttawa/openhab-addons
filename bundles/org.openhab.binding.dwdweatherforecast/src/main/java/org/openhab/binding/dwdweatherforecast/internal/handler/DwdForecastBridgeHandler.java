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

import static org.openhab.binding.dwdweatherforecast.internal.DwdWeatherForecastBindingConstants.*;

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
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
import org.openhab.binding.dwdweatherforecast.internal.config.DwdForecastBridgeConfiguration;
import org.openhab.binding.dwdweatherforecast.internal.connection.DwdWeatherForecastConnection;
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

    private @Nullable ScheduledFuture<?> refreshJob; 

    private HttpClient httpClient;
    private DwdWeatherForecastConnection connection;

    private @Nullable DwdForecastBridgeConfiguration config;

    public DwdForecastBridgeHandler(Bridge bridge, HttpClient httpClient) {
        super(bridge);
        this.httpClient = httpClient;
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (CHANNEL_MAX_TEMPERATURE.equals(channelUID.getId())) {
            if (command instanceof RefreshType) {
                // TODO: handle data refresh
                logger.debug("Refresh Channel Max-Temperature");
            }

            // TODO: handle command

            // Note: if communication with thing fails for some reason,
            // indicate that by setting the status with detail information:
            // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR,
            // "Could not control device at IP address x.x.x.x");
        }
    }

    @Override
    public void initialize() {
        logger.debug("Start initializing DWD Weather Forecast Bridge handler '{}'.", getThing().getUID());
        config = getConfigAs(DwdForecastBridgeConfiguration.class);

        boolean validConfig = true;

        // Validate Configuration Parameter
        int refreshInterval = config.refreshInterval;
        if (refreshInterval < 1) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
                    "@text/offline.error-conf-bridge-refreshInterval");
            validConfig = false;
        }

        if (validConfig) {

            this.connection = new DwdWeatherForecastConnection(this, httpClient);

            updateStatus(ThingStatus.UNKNOWN);

            ScheduledFuture<?> refreshJob = this.refreshJob;
            if (refreshJob == null) {
                this.refreshJob = scheduler.scheduleWithFixedDelay(this::updateThings, 30,
                        TimeUnit.HOURS.toSeconds(refreshInterval), TimeUnit.SECONDS);
            }

        }

        // logger.debug("Finished initializing!");

        // Note: When initialization can NOT be done set the status with more details for further
        // analysis. See also class ThingStatusDetail for all available status details.
        // Add a description to give user information to understand why thing does not work as expected. E.g.
        // updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
        // "Can not access device as username and/or password are invalid");
    }

    private void updateThings() {
        ThingStatus status = ThingStatus.OFFLINE;
        for (Thing thing : this.getThing().getThings()) {
            if (ThingStatus.ONLINE.equals(updateThing((DwdLocalForecastHandler) thing.getHandler(), thing))) {
                status = ThingStatus.ONLINE;
            }
        }
        updateStatus(status);
    }

    private ThingStatus updateThing(DwdLocalForecastHandler handler, Thing thing) {
        if (handler != null && connection != null) {
            //handler.updateData(connection);
            return thing.getStatus();
        } else {
            logger.debug("Cannot update weather data of thing '{}' as location handler is null.", thing.getUID());
            return ThingStatus.OFFLINE;
        }
     }

    public DwdForecastBridgeConfiguration getDwdForecastBridgeConfiguration() {
        return this.config;
    }
}
