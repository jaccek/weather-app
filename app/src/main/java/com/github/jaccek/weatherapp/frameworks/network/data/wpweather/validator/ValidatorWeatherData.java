package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherData;

/**
 * Validator for {@link WpWeatherData}.
 */
public class ValidatorWeatherData
{
    /**
     * Checks if data is valid.
     *
     * @param pWeatherData Data to check.
     * @return True if data is valid or false if data isn't valid.
     */
    public boolean isValid(WpWeatherData pWeatherData)
    {
//        if (pWeatherData == null)
//        {
//            return false;
//        }

        try
        {
            // check wind speed
            if(pWeatherData.getWindSpeed() < 0.0f)
            {
                return false;
            }

            // only check null pointer exception
            pWeatherData.getTemperature();

            if(pWeatherData.getWeatherType() == null
                    || pWeatherData.getWeatherType() == WpWeatherData.WpWeatherType.UNKNOWN)
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
