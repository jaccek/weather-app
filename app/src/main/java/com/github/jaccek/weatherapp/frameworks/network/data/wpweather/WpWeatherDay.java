package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

/**
 * Weather data for one day (from WP weather).
 */
public class WpWeatherDay
{
    private Calendar mDay;
    @SerializedName("sunrise")
    private String mSunriseHour;
    @SerializedName("sunset")
    private String mSunsetHour;
    @SerializedName("weather")
    private List<WpWeatherData> mWeather;

    public boolean isToday()
    {
        // TODO: implement
        return false;
    }

    @Nullable
    public WpWeatherData getWeatherData(Calendar pDate)
    {
        // TODO: implement
        return null;
    }

    public String getSunriseHour()
    {
        return mSunriseHour;
    }

    public void setSunriseHour(String pSunriseHour)
    {
        mSunriseHour = pSunriseHour;
    }

    public String getSunsetHour()
    {
        return mSunsetHour;
    }

    public void setSunsetHour(String pSunsetHour)
    {
        mSunsetHour = pSunsetHour;
    }

    public List<WpWeatherData> getWeather()
    {
        return mWeather;
    }

    public void setWeather(List<WpWeatherData> pWeather)
    {
        mWeather = pWeather;
    }

    public Calendar getDay()
    {
        return mDay;
    }

    public void setDay(Calendar pDay)
    {
        mDay = pDay;
    }
}
