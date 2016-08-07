package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

/**
 * Weather data from WP weather endpoints.
 */
public class WpWeatherForecast
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
    public WpWeatherDay getWeatherDay(Calendar pDate)
    {
        return null;
    }
}
