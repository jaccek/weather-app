package com.github.jaccek.weatherapp.network.data.validator;

import android.support.annotation.NonNull;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherData;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Test for {@link WeatherDataValidator}
 */
public class WeatherDataValidatorTest
{
    @Test
    public void isValidTestValidObject() throws Exception
    {
        WeatherDataValidator validator = new WeatherDataValidator();
        WpWeatherData data = getValidWpWeatherData();

        assertTrue(validator.isValid(data));
    }

    @Test
    public void isValidTestNullObject() throws Exception
    {
        WeatherDataValidator validator = new WeatherDataValidator();
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValidTestNegativeWindSpeed() throws Exception
    {
        WeatherDataValidator validator = new WeatherDataValidator();
        WpWeatherData data = getValidWpWeatherData();

        data.setWindSpeed(-0.1f);
        assertFalse(validator.isValid(data));
    }

    @Test
    public void isValidTestNullWeatherType() throws Exception
    {
        WeatherDataValidator validator = new WeatherDataValidator();
        WpWeatherData data = getValidWpWeatherData();

        data.setWeatherType(null);
        assertFalse(validator.isValid(data));
    }

    @Test
    public void isValidTestUnknownWeatherType() throws Exception
    {
        WeatherDataValidator validator = new WeatherDataValidator();
        WpWeatherData data = getValidWpWeatherData();

        data.setWeatherType(IWeatherData.WeatherType.UNKNOWN);
        assertFalse(validator.isValid(data));
    }

    @NonNull
    private WpWeatherData getValidWpWeatherData()
    {
        WpWeatherData data = new WpWeatherData();

        data.setStartHour(6);
        data.setEndHour(9);
        data.setTemperature(12);
        data.setWindSpeed(3);
        data.setWeatherType(IWeatherData.WeatherType.SUNNY);
        return data;
    }
}