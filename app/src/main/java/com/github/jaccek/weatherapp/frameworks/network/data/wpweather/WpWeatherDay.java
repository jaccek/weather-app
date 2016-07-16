package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherData;
import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherDay;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

/**
 * Weather data for one day (from WP weather).
 */
public class WpWeatherDay implements IWeatherDay
{
    private Calendar mDay;
    @SerializedName("sunrise")
    private String mSunriseHour;
    @SerializedName("sunset")
    private String mSunsetHour;
    @SerializedName("weather")
    private List<WpWeatherData> mWeather;

    @Override
    public boolean isToday()
    {
        return false;
    }

    @Nullable
    @Override
    public IWeatherData getWeatherData(Calendar pDate)
    {
        // TODO: implement
        return null;
    }

    @Override
    public String getSunriseHour()
    {
        return mSunriseHour;
    }

    public void setSunriseHour(String pSunriseHour)
    {
        mSunriseHour = pSunriseHour;
    }

    @Override
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
