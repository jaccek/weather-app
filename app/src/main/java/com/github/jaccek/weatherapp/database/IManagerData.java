package com.github.jaccek.weatherapp.database;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.network.data.IWeatherData;

import java.util.Calendar;

/**
 * Interface for data manager.
 */
public interface IManagerData
{
    @Nullable
    IWeatherData getWeather(Calendar pData);
}
