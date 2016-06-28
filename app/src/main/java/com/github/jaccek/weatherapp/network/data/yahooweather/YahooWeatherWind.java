package com.github.jaccek.weatherapp.network.data.yahooweather;

import com.github.jaccek.weatherapp.network.data.yahooweather.json.MphToKmphJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Class used to store information about wind
 */
public class YahooWeatherWind
{
    public static final float BAD_SPEED_VALUE = -1.0f;

    @SerializedName("speed")
    @JsonAdapter(MphToKmphJsonAdapter.class)
    private float mSpeed = BAD_SPEED_VALUE;

    public float getSpeed()
    {
        return mSpeed;
    }
}
