package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator;

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
            if(pWeatherDay.getSunriseHour() == null)
            {
                return false;
            }

            if(pWeatherDay.getSunsetHour() == null)
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
