package com.github.jaccek.weatherapp.frameworks.database;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.logic.database.IManagerData;
import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherData;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherData;

import java.util.Calendar;

/**
 * ManagerData is used to store data in a phone memory.
 */
public class ManagerData implements IManagerData
{
    @Override
    @Nullable
    public IWeatherData getWeather(Calendar pData)
    {
        // TODO: temporary
        WpWeatherData data = new WpWeatherData();
        data.setWeatherType(IWeatherData.WeatherType.SUNNY);
        data.setWindSpeed(12);
        data.setTemperature(28);

        return data;
    }

    @Override
    public void getActualWeather(DataHandler pDataHandler)
    {
        // TODO: implement
    }
}
