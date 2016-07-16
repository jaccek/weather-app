package com.github.jaccek.weatherapp.frameworks.network.data;

import android.support.annotation.Nullable;

import java.util.Calendar;

/**
 * Interface for weather forecast returned by weather api.
 */
public interface IWeatherForecast
{
    @Nullable
    IWeatherDay getWeatherDay(Calendar pDate);
}
