package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator;

import com.github.jaccek.weatherapp.core.utils.HelperText;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherDay;

/**
 * Validator for {@link WpWeatherDay}.
 */
public class ValidatorWeatherDay
{
    public boolean isValid(WpWeatherDay pWeatherDay)
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
