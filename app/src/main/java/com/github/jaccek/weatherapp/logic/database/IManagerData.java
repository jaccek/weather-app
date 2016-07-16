package com.github.jaccek.weatherapp.logic.database;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherData;

import java.util.Calendar;

/**
 * Interface for data manager.
 */
public interface IManagerData
{
    @Nullable
    IWeatherData getWeather(Calendar pData);
}
