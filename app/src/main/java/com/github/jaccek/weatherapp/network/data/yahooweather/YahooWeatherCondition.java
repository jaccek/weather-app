package com.github.jaccek.weatherapp.network.data.yahooweather;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.github.jaccek.weatherapp.network.data.yahooweather.json.FahrenheitToCelsiusJsonAdapter;
import com.github.jaccek.weatherapp.network.data.yahooweather.json.YahooCodeToWeatherTypeJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Current weather condition from Yahoo Weather
 */
public class YahooWeatherCondition
{
    @SerializedName("code")
    @JsonAdapter(YahooCodeToWeatherTypeJsonAdapter.class)
    IWeatherData.WeatherType mWeatherType = IWeatherData.WeatherType.UNKNOWN;
    @SerializedName("temp")
    @JsonAdapter(FahrenheitToCelsiusJsonAdapter.class)
    float mTemperature;

    public IWeatherData.WeatherType getWeatherType()
    {
        return mWeatherType;
    }

    public float getTemperature()
    {
        return mTemperature;
    }
}
