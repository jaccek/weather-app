package com.github.jaccek.weatherapp.models;

/**
 * Created by jacek on 10/2/16.
 */
public enum WeatherType
{
    NO_CLOUDS("B", "C"),
    SOME_CLOUDS("H", "I"),
    CLOUDS("N", "N"),
    RAIN("R", "R"),
    STORM("Z", "Z"),
    SNOW("W", "W"),
    FOG("J", "K"),
    HAIL("X", "X");

    private String mSymbolDay;
    private String mSymbolNight;

    WeatherType(String pSymbolDay, String pSymbolNight)
    {
        mSymbolDay = pSymbolDay;
        mSymbolNight = pSymbolNight;
    }

    public String getSymbolDay()
    {
        return mSymbolDay;
    }

    public String getSymbolNight()
    {
        return mSymbolNight;
    }
}
