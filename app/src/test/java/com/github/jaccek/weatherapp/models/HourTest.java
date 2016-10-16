package com.github.jaccek.weatherapp.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 10/2/16.
 */
public class HourTest
{
    @Test
    public void testToStringMoreThan10Minutes() throws Exception
    {
        Hour hour = new Hour(10, 23);

        assertEquals("10:23", hour.toString());
    }

    @Test
    public void testToStringLessThan10Minutes() throws Exception
    {
        Hour hour = new Hour(8, 3);

        assertEquals("8:03", hour.toString());
    }

}