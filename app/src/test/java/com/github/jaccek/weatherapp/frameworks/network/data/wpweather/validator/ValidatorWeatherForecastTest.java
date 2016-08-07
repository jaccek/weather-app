package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ValidatorWeatherForecast}.
 */
public class ValidatorWeatherForecastTest
{
    @Test
    public void testIsValidCorrectObject() throws Exception
    {
        ValidatorWeatherForecast validator = new ValidatorWeatherForecast();
        WpWeatherForecast forecast = new WpWeatherForecast();

        assertTrue(validator.isValid(forecast));
    }

    @Test
    public void testIsValidNullObject() throws Exception
    {
        ValidatorWeatherForecast validator = new ValidatorWeatherForecast();
        assertFalse(validator.isValid(null));
    }
}