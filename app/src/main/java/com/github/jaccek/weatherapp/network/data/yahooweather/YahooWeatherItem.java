package com.github.jaccek.weatherapp.network.data.yahooweather;

import com.google.gson.annotations.SerializedName;

/**
 * Currently weather condition from Yahoo Weather
 */
public class YahooWeatherItem
{
    @SerializedName("condition")
    YahooWeatherCondition mCondition;

    public YahooWeatherCondition getCondition()
    {
        return mCondition;
    }
}
