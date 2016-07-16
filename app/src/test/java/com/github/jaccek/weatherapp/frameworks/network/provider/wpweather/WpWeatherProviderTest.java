package com.github.jaccek.weatherapp.frameworks.network.provider.wpweather;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherForecast;
import com.github.jaccek.weatherapp.frameworks.network.data.validator.ValidatorWeatherForecast;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link WpWeatherProvider}.
 */
public class WpWeatherProviderTest
{
    @Test
    public void testGetWeatherDataNonNullObject() throws Exception
    {
        WpWeatherProvider provider = new WpWeatherProvider();
        IWeatherForecast data = provider.getWeatherForecast();

        assertNotNull(data);
    }

    @Test
    public void testGetWeatherDataValidObject() throws Exception
    {
        WpWeatherProvider provider = new WpWeatherProvider();
        IWeatherForecast data = provider.getWeatherForecast();
        ValidatorWeatherForecast validator = new ValidatorWeatherForecast();

        assertTrue(validator.isValid(data));
    }
}