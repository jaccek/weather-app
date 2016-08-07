package com.github.jaccek.weatherapp.logic.database;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.frameworks.database.DataHandler;

import java.util.Calendar;

/**
 * Interface for data manager.
 */
public interface IManagerData
{
    @Nullable
    void getActualWeather(Calendar pActualDate, DataHandler<WeatherDataActual> pDataHandler);
}
