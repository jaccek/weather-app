package com.github.jaccek.weatherapp.models;

/**
 * Created by jacek on 8/20/16.
 */
public class ActualWeatherData
{
    private int mTemperature;
    private int mPressure;
    private Hour mSunriseHour;
    private Hour mSunsetHour;
    private WeatherType mWeatherType;

    public void setTemperature(int pTemperature)
    {
        mTemperature = pTemperature;
    }

    public int getTemperature()
    {
        return mTemperature;
    }

    public void setPressure(int pPressure)
    {
        mPressure = pPressure;
    }

    public int getPressure()
    {
        return mPressure;
    }

    public void setSunriseHour(Hour pSunriseHour)
    {
        mSunriseHour = pSunriseHour;
    }

    public Hour getSunriseHour()
    {
        return mSunriseHour;
    }

    public void setSunsetHour(Hour pSunsetHour)
    {
        mSunsetHour = pSunsetHour;
    }

    public Hour getSunsetHour()
    {
        return mSunsetHour;
    }

    public void setWeatherType(WeatherType pWeatherType)
    {
        mWeatherType = pWeatherType;
    }

    public WeatherType getWeatherType()
    {
        return mWeatherType;
    }
}
