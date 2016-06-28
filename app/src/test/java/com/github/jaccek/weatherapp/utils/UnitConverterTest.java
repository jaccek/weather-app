package com.github.jaccek.weatherapp.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 6/24/16.
 */
public class UnitConverterTest
{
    @Test
    public void testConvertFahrenheitToCelsius()
    {
        float actual = UnitConverter.fahrenheitToCelsius(212.0f);
        float expected = 100.0f;
        assertEquals(expected, actual, 0.001f);
    }

    @Test
    public void testConvertMphToKmph()
    {
        float actual = UnitConverter.mphToKmph(100.0f);
        float expected = 160.9344f;
        assertEquals(expected, actual, 0.001f);
    }
}
