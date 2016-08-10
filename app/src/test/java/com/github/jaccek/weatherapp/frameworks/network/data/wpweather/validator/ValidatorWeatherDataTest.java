package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator;

import android.support.annotation.NonNull;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherData;

import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Test for {@link ValidatorWeatherData}
 */
public class ValidatorWeatherDataTest
{
    @Test
    public void isValidTestValidObject() throws Exception
    {
        ValidatorWeatherData validator = new ValidatorWeatherData();
        WpWeatherData data = getValidWpWeatherData();

        assertTrue(validator.isValid(data));
    }

    @Test
    public void isValidTestNullObject() throws Exception
    {
        ValidatorWeatherData validator = new ValidatorWeatherData();
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValidTestNullWeatherType() throws Exception
    {
        ValidatorWeatherData validator = new ValidatorWeatherData();
        WpWeatherData data = getValidWpWeatherData();

        data.setWeatherType(null);
        assertFalse(validator.isValid(data));
    }

    @Test
    public void isValidTestUnknownWeatherType() throws Exception
    {
        ValidatorWeatherData validator = new ValidatorWeatherData();
        WpWeatherData data = getValidWpWeatherData();

        data.setWeatherType(WpWeatherData.WpWeatherType.UNKNOWN);
        assertFalse(validator.isValid(data));
    }

    @NonNull
    public static WpWeatherData getValidWpWeatherData()
    {
        WpWeatherData data = new WpWeatherData();

        data.setTime(Calendar.getInstance());
        data.setTemperature(12);
        data.setPressure(1024);
        data.setWeatherType(WpWeatherData.WpWeatherType.SUNNY);
        return data;
    }
}