package com.github.jaccek.weatherapp.frameworks.utils;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link WeatherTypeConverter}.
 */
public class WeatherTypeConverterTest
{
    @Test
    public void testToStringSunny() throws Exception
    {
        assertEquals("B", WeatherTypeConverter.toString(WeatherType.SUNNY));
    }

    @Test
    public void testToStringCloudy() throws Exception
    {
        assertEquals("H", WeatherTypeConverter.toString(WeatherType.CLOUDY));
    }

    @Test
    public void testToStringMostlyCloudy() throws Exception
    {
        assertEquals("N", WeatherTypeConverter.toString(WeatherType.MOSTLY_CLOUDY));
    }

    @Test
    public void testToStringFoggy() throws Exception
    {
        assertEquals("M", WeatherTypeConverter.toString(WeatherType.FOGGY));
    }

    @Test
    public void testToStringRainy() throws Exception
    {
        assertEquals("R", WeatherTypeConverter.toString(WeatherType.RAINY));
    }

    @Test
    public void testToStringSnow() throws Exception
    {
        assertEquals("X", WeatherTypeConverter.toString(WeatherType.SNOW));
    }

    @Test
    public void testToStringStorm() throws Exception
    {
        assertEquals("O", WeatherTypeConverter.toString(WeatherType.STORM));
    }

    @Test
    public void testToStringUnknown() throws Exception
    {
        assertEquals(")", WeatherTypeConverter.toString(WeatherType.UNKNOWN));
    }
}