package com.github.jaccek.weatherapp.network.data.wpweather;

import com.google.gson.annotations.SerializedName;

/**
 * Weather data for 3 hours (from WP weather).
 */
public class WpWeather3Hours
{
    private int mStartHour;
    private int mEndHour;
    @SerializedName("temp")
    private int mTemperature;
    @SerializedName("windSpeed")
    private int mWindSpeed;

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

    public int getTemperature()
    {
        return mTemperature;
    }

    public void setTemperature(int pTemperature)
    {
        mTemperature = pTemperature;
    }

    public int getWindSpeed()
    {
        return mWindSpeed;
    }

    public void setWindSpeed(int pWindSpeed)
    {
        mWindSpeed = pWindSpeed;
    }
}
