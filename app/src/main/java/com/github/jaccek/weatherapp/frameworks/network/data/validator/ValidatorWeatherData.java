package com.github.jaccek.weatherapp.frameworks.network.data.validator;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherData;

/**
 * Validator for {@link IWeatherData}.
 */
public class ValidatorWeatherData
{
    /**
     * Checks if data is valid.
     *
     * @param pWeatherData Data to check.
     * @return True if data is valid or false if data isn't valid.
     */
    public boolean isValid(IWeatherData pWeatherData)
    {
//        if (pWeatherData == null)
//        {
//            return false;
//        }

        try
        {
            // check wind speed
            if (pWeatherData.getWindSpeed() < 0.0f)
            {
                return false;
            }

            // only check null pointer exception
            pWeatherData.getTemperature();

            if (pWeatherData.getWeatherType() == null
                    || pWeatherData.getWeatherType() == IWeatherData.WeatherType.UNKNOWN)
            {
                return false;
            }
        }
        catch(NullPointerException ex)
        {
            return false;
        }

        return true;
    }
}
