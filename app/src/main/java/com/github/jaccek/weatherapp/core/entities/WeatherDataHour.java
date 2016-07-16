package com.github.jaccek.weatherapp.core.entities;

/**
 * Weather data for one moment in day
 */
public class WeatherDataHour
{
    private int mTemperature;
    private float mWindSpeed;

    public int getTemperature()
    {
        return mTemperature;
    }

    public void setTemperature(int pTemperature)
    {
        mTemperature = pTemperature;
    }
}
