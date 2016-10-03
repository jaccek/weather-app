package com.github.jaccek.weatherapp.network.data.converter;

import com.github.jaccek.weatherapp.data.WeatherType;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.data.RawWeatherType;

/**
 * Created by jacek on 10/2/16.
 */

public class ConverterWeatherType
{
    public WeatherType convert(RawWeatherType pRawWeatherType) throws ExceptionConversion
    {
        switch(pRawWeatherType)
        {
            case NO_CLOUDS:
                return WeatherType.NO_CLOUDS;

            case SOME_CLOUDS:
                return WeatherType.SOME_CLOUDS;

            case CLOUDS:
                return WeatherType.CLOUDS;

            case RAIN:
                return WeatherType.RAIN;

            case STORM:
                return WeatherType.STORM;

            case SNOW:
                return WeatherType.SNOW;

            case FOG:
                return WeatherType.FOG;

            case HAIL:
                return WeatherType.HAIL;
        }

        throw new ExceptionConversion("Unknown weather type: " + pRawWeatherType);
    }
}
