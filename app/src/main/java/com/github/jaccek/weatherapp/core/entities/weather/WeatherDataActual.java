package com.github.jaccek.weatherapp.core.entities.weather;

import com.github.jaccek.weatherapp.core.entities.Hour;

/**
 * Weather data for actual moment.
 */
public class WeatherDataActual
{
    private int mTemperature;
    private float mWindSpeed;
    private Hour mSunriseHour;
    private Hour mSunsetHour;
    private WeatherType mWeatherType;

    public int getTemperature()
    {
        return mTemperature;
    }

    public void setTemperature(int pTemperature)
    {
        mTemperature = pTemperature;
    }

    public float getWindSpeed()
    {
        return mWindSpeed;
    }

    public void setWindSpeed(float pWindSpeed)
    {
        mWindSpeed = pWindSpeed;
    }

    public Hour getSunriseHour()
    {
        return mSunriseHour;
    }

    public void setSunriseHour(Hour pSunriseHour)
    {
        mSunriseHour = pSunriseHour;
    }

    public Hour getSunsetHour()
    {
        return mSunsetHour;
    }

    public void setSunsetHour(Hour pSunsetHour)
    {
        mSunsetHour = pSunsetHour;
    }

    public WeatherType getWeatherType()
    {
        return mWeatherType;
    }

    public void setWeatherType(WeatherType pWeatherType)
    {
        mWeatherType = pWeatherType;
    }
}
