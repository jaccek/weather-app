package com.github.jaccek.weatherapp.network.data.yahooweather;

import com.github.jaccek.weatherapp.network.data.yahooweather.json.StringToTimestampJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Object used to receive information about sunrise and sunset.
 */
public class YahooWeatherAstronomy
{
    @SerializedName("sunrise")
    @JsonAdapter(StringToTimestampJsonAdapter.class)
    private long mSunriseTimestamp;
    @SerializedName("sunset")
    @JsonAdapter(StringToTimestampJsonAdapter.class)
    private long mSunsetTimestamp;

    public long getSunriseTimestamp()
    {
        return mSunriseTimestamp;
    }

    public long getSunsetTimestamp()
    {
        return mSunsetTimestamp;
    }
}
