package com.github.jaccek.weatherapp.network.data.wpweather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Weather data for one day (from WP weather).
 */
public class WpWeatherDay // TODO: add interface
{
    private long mDayTimestamp;
    @SerializedName("sunrise")
    private String mSunriseHour;
    @SerializedName("sunset")
    private String mSunsetHour;
    @SerializedName("weather")
    private List<WpWeatherData> mWeather;

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
}
