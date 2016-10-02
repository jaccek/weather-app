package com.github.jaccek.weatherapp.network.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jacek on 10/2/16.
 */
public enum RawWeatherType
{
    @SerializedName(value = "1d", alternate = "1n")
    NO_CLOUDS,
    @SerializedName(value = "2d", alternate = "2n")
    SOME_CLOUDS,
    @SerializedName(value = "3d", alternate = {"3n", "4"})
    CLOUDS,
    @SerializedName(value = "5d", alternate = {"5n", "6", "9d", "9n", "10"})
    RAIN,
    @SerializedName(value = "7")
    STORM,
    @SerializedName(value = "8")
    HAIL,
    @SerializedName(value = "11d", alternate = {"11n", "12"})
    SNOW,
    @SerializedName(value = "13")
    FOG
}
