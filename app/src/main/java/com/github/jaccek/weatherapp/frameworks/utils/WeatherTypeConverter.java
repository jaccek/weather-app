package com.github.jaccek.weatherapp.frameworks.utils;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherType;

/**
 * Converts {@link WeatherType} to character displayed in TextView using Meteocons font.
 */
public class WeatherTypeConverter
{
    /**
     * Converts {@link WeatherType} to character displayed in TextView using Meteocons font.
     *
     * @param pWeatherType Weather type.
     * @return String to display in TextView.
     */
    public static String toString(WeatherType pWeatherType)
    {
        switch(pWeatherType)
        {
            case SUNNY:
                return "B";

            case CLOUDY:
                return "H";

            case MOSTLY_CLOUDY:
                return "N";

            case FOGGY:
                return "M";

            case RAINY:
                return "R";

            case SNOW:
                return "X";

            case STORM:
                return "O";

            case UNKNOWN:
            default:
                return ")";
        }
    }
}
