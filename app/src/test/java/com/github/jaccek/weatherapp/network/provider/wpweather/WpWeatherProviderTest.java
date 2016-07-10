package com.github.jaccek.weatherapp.network.provider.wpweather;

import com.github.jaccek.weatherapp.network.data.IWeatherData;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Tests for {@link WpWeatherProvider}.
 */
public class WpWeatherProviderTest
{
    @Test
    public void testGetWeatherDataNonNullObject() throws Exception
    {
        WpWeatherProvider provider = new WpWeatherProvider();
        IWeatherData data = provider.getWeatherData();

        assertNotNull(data);
    }

//    @Test
//    public void testGetWeatherDataValidObject() throws Exception
//    {
//        WpWeatherProvider provider = new WpWeatherProvider();
//        IWeatherData data = provider.getWeatherData();
//        WeatherDataValidator validator = new WeatherDataValidator();
//
//        assertTrue(validator.isValid(data));
//    }
}