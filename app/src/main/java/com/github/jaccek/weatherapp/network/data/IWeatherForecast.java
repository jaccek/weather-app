package com.github.jaccek.weatherapp.network.data;

import android.support.annotation.Nullable;

import java.util.Calendar;

/**
 * Interface for weather forecast returned by weather api.
 */
public interface IWeatherForecast
{
    @Nullable
    IWeatherData getWeatherData(Calendar pDate);
}
