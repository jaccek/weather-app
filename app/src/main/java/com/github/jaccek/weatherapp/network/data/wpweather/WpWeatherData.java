package com.github.jaccek.weatherapp.network.data.wpweather;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Weather data from WP weather endpoints.
 */
public class WpWeatherData implements IWeatherData
{
    @SerializedName("days")
    List<WpWeatherDay> mDays;

    @Override
    public float getWindSpeed()
    {
        return 0;
    }

    @Override
    public float getTemperature()
    {
        return 0;
    }

    @Override
    public WeatherType getWeatherType()
    {
        return null;
    }

    @Override
    public boolean isToday()
    {
        return false;
    }

    @Override
    public long getSunriseTimestamp()
    {
        return 0;
    }

    @Override
    public long getSunsetTimestamp()
    {
        return 0;
    }
}
