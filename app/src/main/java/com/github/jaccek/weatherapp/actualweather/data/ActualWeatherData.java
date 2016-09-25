package com.github.jaccek.weatherapp.actualweather.data;

import java.util.Locale;

/**
 * Created by jacek on 8/20/16.
 */
public class ActualWeatherData
{
    private int mTemperature;

    public void setTemperature(int pTemperature)
    {
        mTemperature = pTemperature;
    }

    public String getTemperature()
    {
        return String.format(Locale.getDefault(), "%1$d", mTemperature);
    }
}
