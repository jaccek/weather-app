package com.github.jaccek.weatherapp.network.data.wpweather;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.network.data.IWeatherDay;
import com.github.jaccek.weatherapp.network.data.IWeatherForecast;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

/**
 * Weather data from WP weather endpoints.
 */
public class WpWeatherForecast implements IWeatherForecast
{
    @SerializedName("days")
    List<WpWeatherDay> mDays;

    public List<WpWeatherDay> getDays()
    {
        return mDays;
    }

    public void setDays(List<WpWeatherDay> pDays)
    {
        mDays = pDays;
    }

    @Nullable
    @Override
    public IWeatherDay getWeatherDay(Calendar pDate)
    {
        return null;
    }
}
