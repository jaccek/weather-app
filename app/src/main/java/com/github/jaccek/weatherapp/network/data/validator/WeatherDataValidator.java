package com.github.jaccek.weatherapp.network.data.validator;

import com.github.jaccek.weatherapp.network.data.IWeatherData;

/**
 * Validator for {@link IWeatherData}.
 */
public class WeatherDataValidator
{
    /**
     * Checks if data is valid.
     *
     * @param pWeatherData Data to check.
     * @return True if data is valid or false if data isn't valid.
     */
    public boolean isValid(IWeatherData pWeatherData)
    {
        try
        {
            // check wind speed
            if (pWeatherData.getWindSpeed() < 0.0f)
            {
                return false;
            }

            // check sunrise and sunset
            if (pWeatherData.getSunriseTimestamp() <= 0L)
            {
                return false;
            }
            if (pWeatherData.getSunsetTimestamp() <= 0L)
            {
                return false;
            }

            // only check null pointer exception
            pWeatherData.getTemperature();
            pWeatherData.getWeatherType();
        }
        catch(NullPointerException ex)
        {
            return false;
        }

        return true;
    }
}
