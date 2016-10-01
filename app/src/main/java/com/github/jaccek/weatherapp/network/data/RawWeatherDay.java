package com.github.jaccek.weatherapp.network.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jacek on 10/1/16.
 */
public class RawWeatherDay
{
    @SerializedName("date")
    private long mTimestamp;
    @SerializedName("timeOfDay")
    private List<RawWeatherPeriod> mWeatherPeriods;

    public long getTimestamp()
    {
        return mTimestamp * 1000L;
    }

    public List<RawWeatherPeriod> getWeatherPeriods()
    {
        return mWeatherPeriods;
    }
}
