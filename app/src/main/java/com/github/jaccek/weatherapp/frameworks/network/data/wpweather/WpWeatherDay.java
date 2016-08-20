package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.core.entities.Hour;
import com.github.jaccek.weatherapp.core.utils.HelperCalendar;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.json.JsonAdapterStringToHour;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.json.JsonAdapterTimestampToCalendar;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

/**
 * Weather data for one day (from WP weather).
 */
public class WpWeatherDay
{
    @SerializedName("date")
    @JsonAdapter(JsonAdapterTimestampToCalendar.class)
    private Calendar mDay;
    @SerializedName("sunrise")
    @JsonAdapter(JsonAdapterStringToHour.class)
    private Hour mSunriseHour;
    @SerializedName("sunset")
    @JsonAdapter(JsonAdapterStringToHour.class)
    private Hour mSunsetHour;
    @SerializedName("timeOfDay")
    private List<WpWeatherData> mWeather;

    @Nullable
    public WpWeatherData getWeatherData(Calendar pDate)
    {
        if (mWeather == null)
        {
            return null;
        }

        if (!HelperCalendar.areDaysTheSame(pDate, mDay))
        {
            return null;
        }

        int closestData = -1;
        long smallestDifference = Long.MAX_VALUE;
        for (int i = 0; i < mWeather.size(); ++i)
        {
            WpWeatherData data = mWeather.get(i);
            long dateTimestamp = pDate.getTimeInMillis();
            long weatherTimestamp = pDate.getTimeInMillis();

            long currentDifference = Math.abs(dateTimestamp - weatherTimestamp);
            if (smallestDifference > currentDifference)
            {
                closestData = i;
                smallestDifference = currentDifference;
            }
        }

        if (closestData == -1)
        {
            return null;
        }

        return mWeather.get(closestData);
    }

    public Hour getSunriseHour()
    {
        return mSunriseHour;
    }

    public void setSunriseHour(Hour pSunriseHour)
    {
        mSunriseHour = pSunriseHour;
    }

    public Hour getSunsetHour()
    {
        return mSunsetHour;
    }

    public void setSunsetHour(Hour pSunsetHour)
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
