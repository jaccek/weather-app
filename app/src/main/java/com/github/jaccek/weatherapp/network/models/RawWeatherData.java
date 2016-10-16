package com.github.jaccek.weatherapp.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jacek on 8/21/16.
 */
public class RawWeatherData
{
    @SerializedName("cid")
    private int mCityId;
    @SerializedName("cityName")
    private String mCityName;
    @SerializedName("days")
    private List<RawWeatherDay> mDays;

    public List<RawWeatherDay> getDays()
    {
        return mDays;
    }
}
