package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.json.JsonAdapterTimestampToCalendar;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;

/**
 * Weather data for 3 hours (from WP weather).
 */
public class WpWeatherData
{
    public enum WpWeatherType
    {
        SUNNY,
        CLOUDY,
        MOSTLY_CLOUDY,
        FOGGY,
        RAINY,
        SNOW,
        STORM,
        UNKNOWN;

        public com.github.jaccek.weatherapp.core.entities.weather.WeatherType convertWeatherType()
        {
            // TODO: not null
            return null;
        }
    }

    @SerializedName("time")
    @JsonAdapter(JsonAdapterTimestampToCalendar.class)
    private Calendar mTime;
    @SerializedName("temperature")
    private int mTemperature;
    @SerializedName("pressure")
    private int mPressure;
//    @SerializedName("icon")
    private WpWeatherType mWeatherType;

    public WpWeatherType getWeatherType()
    {
        return mWeatherType;
    }

    public void setWeatherType(WpWeatherType pWeatherType)
    {
        mWeatherType = pWeatherType;
    }

    public int getTemperature()
    {
        return mTemperature;
    }

    public void setTemperature(int pTemperature)
    {
        mTemperature = pTemperature;
    }

    public Calendar getTime()
    {
        return mTime;
    }

    public void setTime(Calendar pTime)
    {
        mTime = pTime;
    }

    public int getPressure()
    {
        return mPressure;
    }

    public void setPressure(int pPressure)
    {
        mPressure = pPressure;
    }
}
