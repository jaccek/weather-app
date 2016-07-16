package com.github.jaccek.weatherapp.frameworks.network.data.validator;

import android.support.annotation.NonNull;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherDay;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ValidatorWeatherDay}.
 */
public class ValidatorWeatherDayTest
{
    @Test
    public void isValidTestValidObject() throws Exception
    {
        ValidatorWeatherDay validator = new ValidatorWeatherDay();
        WpWeatherDay weatherDay = getValidWpWeatherDay();

        assertTrue(validator.isValid(weatherDay));

    }

    @Test
    public void isValidTestNullObject() throws Exception
    {
        ValidatorWeatherDay validator = new ValidatorWeatherDay();
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValidTestNullSunrise() throws Exception
    {
        ValidatorWeatherDay validator = new ValidatorWeatherDay();
        WpWeatherDay weatherDay = getValidWpWeatherDay();

        weatherDay.setSunriseHour(null);
        assertFalse(validator.isValid(weatherDay));
    }

    @Test
    public void isValidTestEmptySunrise() throws Exception
    {
        ValidatorWeatherDay validator = new ValidatorWeatherDay();
        WpWeatherDay weatherDay = getValidWpWeatherDay();

        weatherDay.setSunriseHour("");
        assertFalse(validator.isValid(weatherDay));
    }

    @Test
    public void isValidTestNullSunset() throws Exception
    {
        ValidatorWeatherDay validator = new ValidatorWeatherDay();
        WpWeatherDay weatherDay = getValidWpWeatherDay();

        weatherDay.setSunsetHour(null);
        assertFalse(validator.isValid(weatherDay));
    }

    @Test
    public void isValidTestEmptySunset() throws Exception
    {
        ValidatorWeatherDay validator = new ValidatorWeatherDay();
        WpWeatherDay weatherDay = getValidWpWeatherDay();

        weatherDay.setSunsetHour("");
        assertFalse(validator.isValid(weatherDay));
    }

    @NonNull
    public static WpWeatherDay getValidWpWeatherDay()
    {
        WpWeatherDay weatherDay = new WpWeatherDay();
        weatherDay.setSunriseHour("9:23");
        weatherDay.setSunsetHour("20:45");

        return weatherDay;
    }
}