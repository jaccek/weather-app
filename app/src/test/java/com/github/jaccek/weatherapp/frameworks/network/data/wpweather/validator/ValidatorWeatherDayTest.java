package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator;

import android.support.annotation.NonNull;

import com.github.jaccek.weatherapp.core.entities.Hour;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherDay;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ValidatorWeatherDay}.
 */
public class ValidatorWeatherDayTest
{
    ValidatorWeatherDay mValidator = new ValidatorWeatherDay();
    WpWeatherDay mWeatherDay = getValidWpWeatherDay();

    @Before
    public void init()
    {
        mValidator = new ValidatorWeatherDay();
        mWeatherDay = getValidWpWeatherDay();
    }

    @Test
    public void isValidTestValidObject() throws Exception
    {
        assertTrue(mValidator.isValid(mWeatherDay));
    }

    @Test
    public void isValidTestNullObject() throws Exception
    {
        assertFalse(mValidator.isValid(null));
    }

    @Test
    public void isValidTestNullSunrise() throws Exception
    {
        mWeatherDay.setSunriseHour(null);
        assertFalse(mValidator.isValid(mWeatherDay));
    }

    @Test
    public void isValidTestEmptySunrise() throws Exception
    {
        mWeatherDay.setSunriseHour(null);
        assertFalse(mValidator.isValid(mWeatherDay));
    }

    @Test
    public void isValidTestNullSunset() throws Exception
    {
        mWeatherDay.setSunsetHour(null);
        assertFalse(mValidator.isValid(mWeatherDay));
    }

    @Test
    public void isValidTestEmptySunset() throws Exception
    {
        mWeatherDay.setSunsetHour(null);
        assertFalse(mValidator.isValid(mWeatherDay));
    }

    @NonNull
    public static WpWeatherDay getValidWpWeatherDay()
    {
        WpWeatherDay weatherDay = new WpWeatherDay();
        weatherDay.setSunriseHour(new Hour(9, 23));
        weatherDay.setSunsetHour(new Hour(20, 45));

        return weatherDay;
    }
}