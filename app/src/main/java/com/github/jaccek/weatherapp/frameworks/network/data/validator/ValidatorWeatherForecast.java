package com.github.jaccek.weatherapp.frameworks.network.data.validator;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherForecast;

/**
 * Validator for {@link IWeatherForecast}.
 */
public class ValidatorWeatherForecast
{
    public boolean isValid(IWeatherForecast pForecast)
    {
        return pForecast != null;
    }

}