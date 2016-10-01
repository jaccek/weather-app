package com.github.jaccek.weatherapp.network.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jacek on 10/1/16.
 */
public class RawWeatherPeriod
{
    @SerializedName("time")
    private long mTimestamp;
    @SerializedName("temperature")
    private int mTemperature;
    @SerializedName("pressure")
    private int mPressure;

    public long getTimestamp()
    {
        return mTimestamp * 1000L;
    }

    public int getTemperature()
    {
        return mTemperature;
    }

    public int getPressure()
    {
        return mPressure;
    }
}
