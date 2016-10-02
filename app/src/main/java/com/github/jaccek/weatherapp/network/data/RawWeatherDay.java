package com.github.jaccek.weatherapp.network.data;

import com.github.jaccek.weatherapp.network.data.json.JsonAdapterStringToHour;
import com.google.gson.annotations.JsonAdapter;
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
    @SerializedName("sunrise")
    @JsonAdapter(JsonAdapterStringToHour.class)
    private RawHour mSunriseHour;
    @SerializedName("sunset")
    @JsonAdapter(JsonAdapterStringToHour.class)
    private RawHour mSunsetHour;

    public long getTimestamp()
    {
        return mTimestamp * 1000L;
    }

    public List<RawWeatherPeriod> getWeatherPeriods()
    {
        return mWeatherPeriods;
    }

    public RawHour getSunriseHour()
    {
        return mSunriseHour;
    }

    public RawHour getSunsetHour()
    {
        return mSunsetHour;
    }
}
