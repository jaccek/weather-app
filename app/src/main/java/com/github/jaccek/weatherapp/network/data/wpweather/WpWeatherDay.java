package com.github.jaccek.weatherapp.network.data.wpweather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Weather data for one day (from WP weather).
 */
public class WpWeatherDay
{
    private long mDayTimestamp;
    @SerializedName("sunrise")
    private long mSunriseTimestamp;
    @SerializedName("sunset")
    private long mSunsetTimestamp;
    @SerializedName("weather")
    private List<WpWeather3Hours> mWeather;

    public long getDayTimestamp()
    {
        return mDayTimestamp;
    }

    public void setDayTimestamp(long pDayTimestamp)
    {
        mDayTimestamp = pDayTimestamp;
    }

    public long getSunriseTimestamp()
    {
        return mSunriseTimestamp;
    }

    public void setSunriseTimestamp(long pSunriseTimestamp)
    {
        mSunriseTimestamp = pSunriseTimestamp;
    }

    public long getSunsetTimestamp()
    {
        return mSunsetTimestamp;
    }

    public void setSunsetTimestamp(long pSunsetTimestamp)
    {
        mSunsetTimestamp = pSunsetTimestamp;
    }

    public List<WpWeather3Hours> getWeather()
    {
        return mWeather;
    }

    public void setWeather(List<WpWeather3Hours> pWeather)
    {
        mWeather = pWeather;
    }
}
