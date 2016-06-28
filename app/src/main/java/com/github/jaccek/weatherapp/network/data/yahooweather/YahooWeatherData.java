package com.github.jaccek.weatherapp.network.data.yahooweather;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.google.gson.annotations.SerializedName;

/**
 * Object returned by Yahoo Weather api.
 */
public class YahooWeatherData implements IWeatherData
{
    @SerializedName("wind")
    YahooWeatherWind mWind;
    @SerializedName("astronomy")
    YahooWeatherAstronomy mAstronomy;
    @SerializedName("item")
    YahooWeatherItem mItem;

    @Override
    public float getWindSpeed()
    {
        return mWind.getSpeed();
    }

    @Override
    public float getTemperature()
    {
        return mItem.getCondition().getTemperature();
    }

    @Override
    public WeatherType getWeatherType()
    {
        return mItem.getCondition().getWeatherType();
    }

    @Override
    public boolean isToday()
    {
        return false;
    }

    @Override
    public long getSunriseTimestamp()
    {
        return mAstronomy.getSunriseTimestamp();
    }

    @Override
    public long getSunsetTimestamp()
    {
        return mAstronomy.getSunsetTimestamp();
    }
}
