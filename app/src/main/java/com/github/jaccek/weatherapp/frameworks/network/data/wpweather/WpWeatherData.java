package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherType;
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
        // TODO: day / night
        // TODO: śnieg z deszczem

        @SerializedName(value = "1d", alternate = "1n")
        SUNNY,
        @SerializedName(value = "2d", alternate = "2n")
        CLOUDY,
        @SerializedName(value = "4", alternate = { "3d", "3n" })
        MOSTLY_CLOUDY,
        @SerializedName("13")
        FOGGY,
        @SerializedName(value = "6", alternate = { "5d", "5n" })
        RAINY,
        @SerializedName(value = "8", alternate = { "11d", "11n", "12" })
        SNOW,
        @SerializedName(value = "7", alternate = { "9d", "9n", "10" })
        STORM,
        UNKNOWN;

        public WeatherType convertWeatherType()
        {
            switch(this)
            {
                case SUNNY:
                    return WeatherType.SUNNY;

                case CLOUDY:
                    return WeatherType.CLOUDY;

                case MOSTLY_CLOUDY:
                    return WeatherType.MOSTLY_CLOUDY;

                case FOGGY:
                    return WeatherType.FOGGY;

                case RAINY:
                    return WeatherType.RAINY;

                case SNOW:
                    return WeatherType.SNOW;

                case STORM:
                    return WeatherType.STORM;

                case UNKNOWN:
                default:
                    return WeatherType.UNKNOWN;
            }
        }
    }

    @SerializedName("time")
    @JsonAdapter(JsonAdapterTimestampToCalendar.class)
    private Calendar mTime;
    @SerializedName("temperature")
    private int mTemperature;
    @SerializedName("pressure")
    private int mPressure;
    @SerializedName("icon")
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
