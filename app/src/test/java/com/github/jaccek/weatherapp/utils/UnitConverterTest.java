package com.github.jaccek.weatherapp.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 6/24/16.
 */
public class UnitConverterTest
{
    @Test
    public void testFahrenheitToCelsius() throws Exception
    {
        float actual = UnitConverter.fahrenheitToCelsius(212.0f);
        float expected = 100.0f;
        assertEquals(expected, actual, 0.001f);
    }

    @Test
    public void testMphToKmph() throws Exception
    {
        float actual = UnitConverter.mphToKmph(100.0f);
        float expected = 160.9344f;
        assertEquals(expected, actual, 0.001f);
    }

    @Test
    public void testTimestampToDate() throws Exception
    {
        String date = UnitConverter.timestampToDate(1467660743000L);
        String expected = "04.07.2016";
        assertEquals(expected, date);
    }

    @Test
    public void testTimestampToHourLessThan10() throws Exception
    {
        String date = UnitConverter.timestampToHour(1467660743000L);
        String expected = "9:32 pm";
        assertEquals(expected, date);
    }

    @Test
    public void testTimestampToHourBiggerThan10() throws Exception
    {
        String date = UnitConverter.timestampToHour(1467624180000L);
        String expected = "11:23 am";
        assertEquals(expected, date);
    }
}
