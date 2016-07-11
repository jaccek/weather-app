package com.github.jaccek.weatherapp.network.data;

import android.support.annotation.Nullable;

import java.util.Calendar;

/**
 * Objects implementing this interface store weather data for one day.
 */
public interface IWeatherDay
{
    boolean isToday();

    @Nullable
    IWeatherData getWeatherData(Calendar pDate);

    String getSunriseHour();
    String getSunsetHour();
}
