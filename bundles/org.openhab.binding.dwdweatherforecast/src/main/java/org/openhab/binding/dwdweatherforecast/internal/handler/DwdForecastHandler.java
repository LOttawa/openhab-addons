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

import static org.eclipse.smarthome.core.library.unit.SIUnits.*;
import static org.eclipse.smarthome.core.library.unit.SmartHomeUnits.*;
import static org.openhab.binding.dwdweatherforecast.internal.DwdForecastBindingConstants.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.measure.Unit;

import com.google.gson.JsonSyntaxException;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.smarthome.core.library.types.DateTimeType;
import org.eclipse.smarthome.core.library.types.PointType;
import org.eclipse.smarthome.core.library.types.QuantityType;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.Channel;
import org.eclipse.smarthome.core.thing.ChannelGroupUID;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.ThingStatusInfo;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.thing.binding.ThingHandlerCallback;
import org.eclipse.smarthome.core.thing.binding.builder.ChannelBuilder;
import org.eclipse.smarthome.core.thing.binding.builder.ThingBuilder;
import org.eclipse.smarthome.core.thing.type.ChannelGroupTypeUID;
import org.eclipse.smarthome.core.thing.type.ChannelKind;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.RefreshType;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.UnDefType;
import org.openhab.binding.dwdweatherforecast.internal.config.DwdForecastHandlerConfiguration;
import org.openhab.binding.dwdweatherforecast.internal.connection.DwdForecastConnection;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdCurrentData;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdDailyData;
import org.openhab.binding.dwdweatherforecast.internal.dto.DwdWeatherData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link dwdWeatherForecastHandler} is responsible for handling commands,
 * which are sent to one of the channels.
 *
 * @author Lars Ottawa - Initial contribution
 */
@NonNullByDefault
public class DwdForecastHandler extends BaseThingHandler {

    private final Logger logger = LoggerFactory.getLogger(DwdForecastHandler.class);

    // keeps track of all jobs
    private static final Map<String, Job> JOBS = new ConcurrentHashMap<>();

    protected PointType location;
    private int forecastDays = 8;

    public static final Set<ThingTypeUID> SUPPORTED_THING_TYPES = Collections.singleton(THING_TYPE_DWD_LOCAL_FORECAST);

    private static final String CHANNEL_GROUP_DAILY_FORECAST_PREFIX = "forecastDay";
    private static final Pattern CHANNEL_GROUP_DAILY_FORECAST_PREFIX_PATTERN = Pattern
            .compile(CHANNEL_GROUP_DAILY_FORECAST_PREFIX + "([0-9]*)");

    private @Nullable DwdWeatherData weatherData;

    private @Nullable DwdForecastHandlerConfiguration config;

    public DwdForecastHandler(Thing thing) {
        super(thing);

        this.location = new PointType();
    }

    @Override
    public void initialize() {
        logger.debug("Initialize DwdLocalForecastHandler handler '{}'.", getThing().getUID());
        DwdForecastHandlerConfiguration config = getConfigAs(DwdForecastHandlerConfiguration.class);

        boolean configValid = true;
        if (config.location == null || config.location.trim().isEmpty()) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
                    "@text/offline.conf-error-missing-location");
            configValid = false;
        }

        try {
            this.location = new PointType(config.location);
        } catch (IllegalArgumentException e) {
            logger.warn("Error parsing 'location' parameter: {}", e.getMessage());
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
                    "@text/offline.conf-error-parsing-location");
            this.location = new PointType();
            configValid = false;
        }

        int newForecastDays = config.forecastDays;
        if (newForecastDays < 0 || newForecastDays > 10) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR,
                    "@text/offline.conf-error-not-supported-number-of-days");
            configValid = false;
        }

        if (configValid) {
            logger.debug("Rebuilding thing '{}'.", getThing().getUID());
            List<Channel> toBeAddedChannels = new ArrayList<>();
            List<Channel> toBeRemovedChannels = new ArrayList<>();

            if (forecastDays != newForecastDays) {
                logger.debug("Rebuilding daily forecast channel groups.");
                if (forecastDays > newForecastDays) {
                    if (newForecastDays < 1) {
                        toBeRemovedChannels.addAll(removeChannelsOfGroup(CHANNEL_GROUP_FORECAST_TOMORROW));
                    }
                    for (int i = newForecastDays; i < forecastDays; ++i) {
                        toBeRemovedChannels.addAll(
                                removeChannelsOfGroup(CHANNEL_GROUP_DAILY_FORECAST_PREFIX + Integer.toString(i)));
                    }
                } else {
                    if (forecastDays == 0 && newForecastDays > 0) {
                        toBeAddedChannels.addAll(createChannelsForGroup(CHANNEL_GROUP_FORECAST_TOMORROW,
                                CHANNEL_GROUP_TYPE_DAILY_FORECAST));
                    }
                    for (int i = (forecastDays < 1) ? 1 : forecastDays; i < newForecastDays; ++i) {
                        toBeAddedChannels.addAll(
                                createChannelsForGroup(CHANNEL_GROUP_DAILY_FORECAST_PREFIX + Integer.toString(i),
                                        CHANNEL_GROUP_TYPE_DAILY_FORECAST));
                    }
                }
                forecastDays = newForecastDays;
            }

            ThingBuilder builder = editThing().withoutChannels(toBeRemovedChannels);
            for (Channel channel : toBeAddedChannels) {
                builder.withChannel(channel);
            }
            updateThing(builder.build());

            updateStatus(ThingStatus.UNKNOWN);
        }
    }

    @Override
    public void dispose() {
        cancelAllJobs();
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        if (command instanceof RefreshType) {
            updateChannel(channelUID);
        } else {
            logger.debug("The Dark Sky binding is a read-only binding and cannot handle command '{}'.", command);
        }
    }

    @Override
    public void bridgeStatusChanged(ThingStatusInfo bridgeStatusInfo) {
        if (ThingStatus.ONLINE.equals(bridgeStatusInfo.getStatus())
                && ThingStatusDetail.BRIDGE_OFFLINE.equals(getThing().getStatusInfo().getStatusDetail())) {
            updateStatus(ThingStatus.ONLINE, ThingStatusDetail.NONE);
        } else if (ThingStatus.OFFLINE.equals(bridgeStatusInfo.getStatus())
                && !ThingStatus.OFFLINE.equals(getThing().getStatus())) {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.BRIDGE_OFFLINE);
        }
    }

    /**
     * Creates all {@link Channel}s for the given {@link ChannelGroupTypeUID}.
     *
     * @param channelGroupId      the channel group id
     * @param channelGroupTypeUID the {@link ChannelGroupTypeUID}
     * @return a list of all {@link Channel}s for the channel group
     */
    private List<Channel> createChannelsForGroup(String channelGroupId, ChannelGroupTypeUID channelGroupTypeUID) {
        logger.debug("Building channel group '{}' for thing '{}'.", channelGroupId, getThing().getUID());
        List<Channel> channels = new ArrayList<>();
        ThingHandlerCallback callback = getCallback();
        if (callback != null) {
            for (ChannelBuilder channelBuilder : callback.createChannelBuilders(
                    new ChannelGroupUID(getThing().getUID(), channelGroupId), channelGroupTypeUID)) {
                Channel newChannel = channelBuilder.build(),
                        existingChannel = getThing().getChannel(newChannel.getUID().getId());
                if (existingChannel != null) {
                    logger.trace("Thing '{}' already has an existing channel '{}'. Omit adding new channel '{}'.",
                            getThing().getUID(), existingChannel.getUID(), newChannel.getUID());
                    continue;
                }
                channels.add(newChannel);
            }
        }
        return channels;
    }

    /**
     * Removes all {@link Channel}s of the given channel group.
     *
     * @param channelGroupId the channel group id
     * @return a list of all {@link Channel}s in the given channel group
     */
    private List<Channel> removeChannelsOfGroup(String channelGroupId) {
        logger.debug("Removing channel group '{}' from thing '{}'.", channelGroupId, getThing().getUID());
        return getThing().getChannelsOfGroup(channelGroupId);
    }

    /**
     * Updates Dark Sky data for this location.
     *
     * @param connection {@link DwdForecastConnection} instance
     */
    public void updateData(@Nullable DwdForecastConnection connection) {
        if (connection != null) {
            try {
                if (requestData(connection)) {
                    updateChannels();
                    updateStatus(ThingStatus.ONLINE);
                }
            } catch (RuntimeException e) {
                updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.COMMUNICATION_ERROR, e.getLocalizedMessage());
//            } catch (IllegalArgumentException e) {
//                updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, e.getLocalizedMessage());
            }
        }
    }

    /**
     * Requests the data from Dark Sky API.
     *
     * @param connection {@link DwdForecastConnection} instance
     * @return true, if the request for the Dark Sky data was successful
     * @throws DarkSkyCommunicationException
     * @throws DarkSkyConfigurationException
     */
    private boolean requestData(DwdForecastConnection connection)
            throws RuntimeException, IllegalArgumentException {
        logger.debug("Update weather and forecast data of thing '{}'.", getThing().getUID());
        try {
            this.weatherData = connection.getWeatherDataFromCache(this.location);
            return true;
        } catch (JsonSyntaxException e) {
            logger.debug("JsonSyntaxException occurred during execution: {}", e.getLocalizedMessage(), e);
            return false;
        }
    }

    /**
     * Updates all channels of this handler from the latest Dark Sky data retrieved.
     */
    private void updateChannels() {
        for (Channel channel : getThing().getChannels()) {
            ChannelUID channelUID = channel.getUID();
            if (ChannelKind.STATE.equals(channel.getKind()) && channelUID.isInGroup() && channelUID.getGroupId() != null
                    && isLinked(channelUID)) {
                updateChannel(channelUID);
            }
        }
    }

    /**
     * Updates the channel with the given UID from the latest Dark Sky data
     * retrieved.
     *
     * @param channelUID UID of the channel
     */
    private void updateChannel(ChannelUID channelUID) {
        String channelGroupId = channelUID.getGroupId();
        switch (channelGroupId) {
            case CHANNEL_GROUP_CURRENT_WEATHER:
                updateCurrentChannel(channelUID);
                break;
            case CHANNEL_GROUP_FORECAST_TOMORROW:
                updateDailyForecastChannel(channelUID, 0);
                break;
            default:
                int i;

                Matcher dailyForecastMatcher = CHANNEL_GROUP_DAILY_FORECAST_PREFIX_PATTERN.matcher(channelGroupId);
                if (dailyForecastMatcher.find() && (i = Integer.parseInt(dailyForecastMatcher.group(1))) > 0
                        && i <= 9) {
                    updateDailyForecastChannel(channelUID, i);
                    break;
                }
                logger.warn("Unknown channel group '{}'. Cannot update channel '{}'.", channelGroupId, channelUID);
                break;
        }
    }

    /**
     * Update the channel from the last Dark Sky data retrieved.
     *
     * @param channelUID the id identifying the channel to be updated
     */
    private void updateCurrentChannel(ChannelUID channelUID) {
        String channelId = channelUID.getIdWithoutGroup();
        String channelGroupId = channelUID.getGroupId();
        if (this.weatherData != null && this.weatherData.getCurrentData() != null) {
            DwdCurrentData currentData = this.weatherData.getCurrentData();
            State state = UnDefType.UNDEF;
            switch (channelId) {
                case CHANNEL_TIME_STAMP:
                    state = getDateTimeTypeState(currentData.getTimestamp());
                    break;
                case CHANNEL_TEMPERATURE:
                    state = getQuantityTypeState(currentData.getTemperature(), KELVIN);
                    break;
                    case CHANNEL_WIND_DIRECTION:
                    state = getQuantityTypeState(currentData.getWindDirection(), DEGREE_ANGLE);
                    break;
                case CHANNEL_WIND_SPEED:
                    state = getQuantityTypeState(currentData.getWindSpeed(), METRE_PER_SECOND);
                    break;
                case CHANNEL_GUST_SPEED:
                    state = getQuantityTypeState(currentData.getGustSpeed(), METRE_PER_SECOND);
                    break;
                case CHANNEL_PRESSURE:
                    state = getQuantityTypeState(currentData.getPressure(), PASCAL);
                    break;
                case CHANNEL_VISIBILITY:
                    state = getQuantityTypeState(currentData.getVisibility(), METRE);
                    break;
                case CHANNEL_PRECIPITATION:
                    state = getQuantityTypeState(currentData.getPrecipitation(), MILLIMETRE_PER_HOUR);
                    break;
                case CHANNEL_CLOUD_COVER:
                    state = getQuantityTypeState(currentData.getCloudCover(), PERCENT);
                    break;
                case CHANNEL_SIGNIFICANT_WEATHER:
                    state = getStringTypeState(currentData.getSignificantWeather());
                    break;
            }
            logger.debug("Update channel '{}' of group '{}' with new state '{}'.", channelId, channelGroupId, state);
            updateState(channelUID, state);
        } else {
            logger.debug("No weather data available to update channel '{}' of group '{}'.", channelId, channelGroupId);
        }
    }

        /**
     * Update the channel from the last Dark Sky data retrieved.
     *
     * @param channelUID the id identifying the channel to be updated
     * @param count
     */
    private void updateDailyForecastChannel(ChannelUID channelUID, int count) {
        String channelId = channelUID.getIdWithoutGroup();
        String channelGroupId = channelUID.getGroupId();

        if (this.weatherData != null && this.weatherData.getDailyData() != null && this.weatherData.getDailyData().size() > count) {
            DwdDailyData forecastData = this.weatherData.getDailyData().get(count);
            State state = UnDefType.UNDEF;
            switch (channelId) {
                case CHANNEL_TIME_STAMP:
                    state = getDateTimeTypeState(forecastData.getTimestamp());
                    break;
                case CHANNEL_MIN_TEMPERATURE:
                    state = getQuantityTypeState(forecastData.getDayForecast().getMinTemperature(), KELVIN);
                    break;
                case CHANNEL_MAX_TEMPERATURE:
                    state = getQuantityTypeState(forecastData.getDayForecast().getMaxTemperature(), KELVIN);
                    break;
                case CHANNEL_WIND_DIRECTION:
                    state = getQuantityTypeState(forecastData.getDayForecast().getWindDirection(), DEGREE_ANGLE);
                    break;
                case CHANNEL_WIND_SPEED:
                    state = getQuantityTypeState(forecastData.getDayForecast().getWindSpeed(), METRE_PER_SECOND);
                    break;
                case CHANNEL_GUST_SPEED:
                    state = getQuantityTypeState(forecastData.getDayForecast().getGustSpeed(), METRE_PER_SECOND);
                    break;
                case CHANNEL_PRESSURE:
                    state = getQuantityTypeState(forecastData.getDayForecast().getPressure(), PASCAL);
                    break;
                case CHANNEL_VISIBILITY:
                    state = getQuantityTypeState(forecastData.getDayForecast().getVisibility(), METRE);
                    break;
                case CHANNEL_PRECIPITATION:
                    state = getQuantityTypeState(forecastData.getDayForecast().getPrecipitation(), MILLIMETRE_PER_HOUR);
                    break;
                case CHANNEL_CLOUD_COVER:
                    state = getQuantityTypeState(forecastData.getDayForecast().getCloudCover(), PERCENT);
                    break;
                case CHANNEL_SIGNIFICANT_WEATHER:
                    state = getStringTypeState(forecastData.getDayForecast().getSignificantWeather());
                    break;
            }
            logger.debug("Update channel '{}' of group '{}' with new state '{}'.", channelId, channelGroupId, state);
            updateState(channelUID, state);
        } else {
            logger.debug("No weather data available to update channel '{}' of group '{}'.", channelId, channelGroupId);
        }
    }

    private State getDateTimeTypeState(long value) {
        return new DateTimeType(ZonedDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault()));
    }

    private State getQuantityTypeState(double value, Unit<?> unit) {
        return new QuantityType<>(value, unit);
    }

    private State getStringTypeState(@Nullable String value) {
        return (value == null) ? UnDefType.UNDEF : new StringType(value);
    }

    /**
     * Schedules or reschedules a job for the channel with the given id if the given
     * timestamp is in the future.
     *
     * @param channelId id of the channel
     * @param dateTime  timestamp of the job represented as {@link ZonedDateTime}
     */
    @SuppressWarnings("null")
    private synchronized void scheduleJob(String channelId, ZonedDateTime dateTime) {
        long delay = dateTime.toEpochSecond() - ZonedDateTime.now().toEpochSecond();
        if (delay > 0) {
            Job job = JOBS.get(channelId);
            if (job == null || job.getFuture().isCancelled()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Schedule job for '{}' in {} s (at '{}').", channelId, delay,
                            dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                }
                JOBS.put(channelId, new Job(channelId, delay));
            } else {
                if (delay != job.getDelay()) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("Reschedule job for '{}' in {} s (at '{}').", channelId, delay,
                                dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    }
                    job.getFuture().cancel(true);
                    JOBS.put(channelId, new Job(channelId, delay));
                }
            }
        }
    }

    /**
     * Cancels all jobs.
     */
    private void cancelAllJobs() {
        logger.debug("Cancel all jobs.");
        JOBS.keySet().forEach(this::cancelJob);
    }

    /**
     * Cancels the job for the channel with the given id.
     *
     * @param channelId id of the channel
     */
    @SuppressWarnings("null")
    private synchronized void cancelJob(String channelId) {
        Job job = JOBS.remove(channelId);
        if (job != null && !job.getFuture().isCancelled()) {
            logger.debug("Cancel job for '{}'.", channelId);
            job.getFuture().cancel(true);
        }
    }

    /**
     * Executes the job for the channel with the given id.
     *
     * @param channelId id of the channel
     */
    private void executeJob(String channelId) {
        logger.debug("Trigger channel '{}' with event '{}'.", channelId, EVENT_START);
        triggerChannel(channelId, EVENT_START);
    }

    @NonNullByDefault
    private final class Job {
        private final long delay;
        private final ScheduledFuture<?> future;

        public Job(String event, long delay) {
            this.delay = delay;
            this.future = scheduler.schedule(() -> {
                executeJob(event);
            }, delay, TimeUnit.SECONDS);
        }

        public long getDelay() {
            return delay;
        }

        public ScheduledFuture<?> getFuture() {
            return future;
        }
    }
}
