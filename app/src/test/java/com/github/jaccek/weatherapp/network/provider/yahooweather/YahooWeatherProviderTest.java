package com.github.jaccek.weatherapp.network.provider.yahooweather;

import com.github.jaccek.weatherapp.network.data.IWeatherData;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link YahooWeatherProvider}
 */
public class YahooWeatherProviderTest
{
    @Test
    public void testServerResponse()
    {
        YahooWeatherProvider provider = new YahooWeatherProvider();
        IWeatherData data = null;
        try
        {
            data = provider.getWeatherData();
        }
        catch(IOException pE)
        {
            pE.printStackTrace();
        }

        assertTrue(data != null);

        // TODO: check if data is correct
    }
}
