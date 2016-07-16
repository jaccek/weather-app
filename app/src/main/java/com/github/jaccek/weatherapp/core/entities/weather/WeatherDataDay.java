package com.github.jaccek.weatherapp.core.entities.weather;

import com.github.jaccek.weatherapp.core.entities.Hour;

/**
 * Weather data for whole day.
 */
public class WeatherDataDay
{
    private int mMinTemperature;
    private int mMaxTemperature;
    private float mMinWindSpeed;
    private float mMaxWindSpeed;
    private Hour mSunriseHour;
    private Hour mSunsetHour;

    public int getMinTemperature()
    {
        return mMinTemperature;
    }

    public void setMinTemperature(int pMinTemperature)
    {
        mMinTemperature = pMinTemperature;
    }

    public int getMaxTemperature()
    {
        return mMaxTemperature;
    }

    public void setMaxTemperature(int pMaxTemperature)
    {
        mMaxTemperature = pMaxTemperature;
    }

    public float getMinWindSpeed()
    {
        return mMinWindSpeed;
    }

    public void setMinWindSpeed(float pMinWindSpeed)
    {
        mMinWindSpeed = pMinWindSpeed;
    }

    public float getMaxWindSpeed()
    {
        return mMaxWindSpeed;
    }

    public void setMaxWindSpeed(float pMaxWindSpeed)
    {
        mMaxWindSpeed = pMaxWindSpeed;
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
}
