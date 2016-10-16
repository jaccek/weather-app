package com.github.jaccek.weatherapp.network.models.converter;

import com.github.jaccek.weatherapp.models.Hour;
import com.github.jaccek.weatherapp.models.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.models.RawHour;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 10/2/16.
 */
public class ConverterHourTest
{
    private ConverterHour mConverter;

    @Before
    public void init()
    {
        mConverter = new ConverterHour();
    }

    @Test(expected = ExceptionConversion.class)
    public void testConvertNull() throws Exception
    {
        mConverter.convert(null);
    }

    @Test
    public void testConvertSuccess() throws Exception
    {
        RawHour rawHour = new RawHour(23, 21);

        Hour convertedHour = mConverter.convert(rawHour);

        assertEquals(rawHour.getHour(), convertedHour.getHour());
        assertEquals(rawHour.getMinutes(), convertedHour.getMinutes());
    }
}