package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherData;
import com.google.gson.annotations.SerializedName;

/**
 * Weather data for 3 hours (from WP weather).
 */
public class WpWeatherData implements IWeatherData
{
    private int mStartHour;
    private int mEndHour;
    @SerializedName("temp")
    private int mTemperature;
    @SerializedName("windSpeed")
    private float mWindSpeed;
    private WeatherType mWeatherType;

    @Override
    public WeatherType getWeatherType()
    {
        return mWeatherType;
    }

    public void setWeatherType(WeatherType pWeatherType)
    {
        mWeatherType = pWeatherType;
    }

    @Override
    public int getTemperature()
    {
        return mTemperature;
    }

    public void setTemperature(int pTemperature)
    {
        mTemperature = pTemperature;
    }

    @Override
    public float getWindSpeed()
    {
        return mWindSpeed;
    }

    public void setWindSpeed(float pWindSpeed)
    {
        mWindSpeed = pWindSpeed;
    }

    public int getStartHour()
    {
        return mStartHour;
    }

    public void setStartHour(int pStartHour)
    {
        mStartHour = pStartHour;
    }

    public int getEndHour()
    {
        return mEndHour;
    }

    public void setEndHour(int pEndHour)
    {
        mEndHour = pEndHour;
    }
}
