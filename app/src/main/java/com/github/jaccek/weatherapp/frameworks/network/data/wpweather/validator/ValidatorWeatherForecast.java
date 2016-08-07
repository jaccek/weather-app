package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;

/**
 * Validator for {@link WpWeatherForecast}.
 */
public class ValidatorWeatherForecast
{
    public boolean isValid(WpWeatherForecast pForecast)
    {
        return pForecast != null;
    }

}
