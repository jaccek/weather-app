package com.github.jaccek.weatherapp.actualweather.data;

import java.util.Locale;

/**
 * Created by jacek on 8/20/16.
 */
public class ActualWeatherData
{
    private float mTemperature;

    public void setTemperature(float pTemperature)
    {
        mTemperature = pTemperature;
    }

    public String getTemperature()
    {
        return String.format(Locale.getDefault(), "%1$.1f", mTemperature);
    }
}
