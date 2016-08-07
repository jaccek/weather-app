package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import com.google.gson.annotations.SerializedName;

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

    private int mStartHour;
    private int mEndHour;
    @SerializedName("temp")
    private int mTemperature;
    @SerializedName("windSpeed")
    private float mWindSpeed;
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

    public float getWindSpeed()
    {
        return mWindSpeed;
    }

    public void setWindSpeed(float pWindSpeed)
    {
        mWindSpeed = pWindSpeed;
    }

    public int getStartHour()
    {
        return mStartHour;
    }

    public void setStartHour(int pStartHour)
    {
        mStartHour = pStartHour;
    }

    public int getEndHour()
    {
        return mEndHour;
    }

    public void setEndHour(int pEndHour)
    {
        mEndHour = pEndHour;
    }
}
