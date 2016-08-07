package com.github.jaccek.weatherapp.frameworks.network.provider.wpweather;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.validator.ValidatorWeatherForecast;

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
        WpWeatherForecast data = provider.getWeatherForecast();

        assertNotNull(data);
    }

    @Test
    public void testGetWeatherDataValidObject() throws Exception
    {
        WpWeatherProvider provider = new WpWeatherProvider();
        WpWeatherForecast data = provider.getWeatherForecast();
        ValidatorWeatherForecast validator = new ValidatorWeatherForecast();

        assertTrue(validator.isValid(data));
    }
}