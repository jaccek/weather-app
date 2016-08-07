package com.github.jaccek.weatherapp.frameworks.database;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.core.entities.weather.WeatherType;
import com.github.jaccek.weatherapp.frameworks.network.provider.IWeatherDataProvider;
import com.github.jaccek.weatherapp.logic.database.IManagerData;

import java.util.Calendar;

/**
 * ManagerData is used to store data in a phone memory.
 */
public class ManagerData implements IManagerData
{
    IWeatherDataProvider mDataProvider;

    public ManagerData(IWeatherDataProvider pWeatherDataProvider)
    {
        mDataProvider = pWeatherDataProvider;
    }

    @Override
    @Nullable
    public void getActualWeather(Calendar pActualDate, DataHandler<WeatherDataActual> pDataHandler)
    {
        // TODO: temporary
        WeatherDataActual data = new WeatherDataActual();
        data.setWeatherType(WeatherType.SUNNY);
        data.setWindSpeed(12);
        data.setTemperature(28);

        pDataHandler.onData(data);
    }
}
