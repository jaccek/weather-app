package com.github.jaccek.weatherapp.actualweather.data;

/**
 * Created by jacek on 8/20/16.
 */
public class ActualWeatherData
{
    private int mTemperature;
    private int mPressure;

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
}
