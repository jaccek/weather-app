package com.github.jaccek.weatherapp.frameworks.network.data.validator;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherDay;
import com.github.jaccek.weatherapp.core.utils.HelperText;

/**
 * Validator for {@link IWeatherDay}.
 */
public class ValidatorWeatherDay
{
    public boolean isValid(IWeatherDay pWeatherDay)
    {
//        if (pWeatherDay == null)
//        {
//            return false;
//        }

        try
        {
            if(HelperText.isStringEmpty(pWeatherDay.getSunriseHour()))
            {
                return false;
            }

            if(HelperText.isStringEmpty(pWeatherDay.getSunsetHour()))
            {
                return false;
            }
        }
        catch(NullPointerException exception)
        {
            return false;
        }

        return true;
    }
}
