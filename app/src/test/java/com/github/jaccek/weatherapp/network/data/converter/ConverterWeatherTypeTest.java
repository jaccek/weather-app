package com.github.jaccek.weatherapp.network.data.converter;

import com.github.jaccek.weatherapp.data.WeatherType;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.data.RawWeatherType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 10/2/16.
 */
public class ConverterWeatherTypeTest
{
    ConverterWeatherType mConverter;

    @Before
    public void init()
    {
        mConverter = new ConverterWeatherType();
    }

    @Test
    public void testConvertNoClouds() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.NO_CLOUDS);
        assertEquals(WeatherType.NO_CLOUDS, convertedType);
    }

    @Test
    public void testConvertSomeClouds() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.SOME_CLOUDS);
        assertEquals(WeatherType.SOME_CLOUDS, convertedType);
    }

    @Test
    public void testConvertClouds() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.CLOUDS);
        assertEquals(WeatherType.CLOUDS, convertedType);
    }

    @Test
    public void testConvertRain() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.RAIN);
        assertEquals(WeatherType.RAIN, convertedType);
    }

    @Test
    public void testConvertStorm() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.STORM);
        assertEquals(WeatherType.STORM, convertedType);
    }

    @Test
    public void testConvertHail() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.HAIL);
        assertEquals(WeatherType.HAIL, convertedType);
    }

    @Test
    public void testConvertSnow() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.SNOW);
        assertEquals(WeatherType.SNOW, convertedType);
    }

    @Test
    public void testConvertFog() throws ExceptionConversion
    {
        WeatherType convertedType = mConverter.convert(RawWeatherType.FOG);
        assertEquals(WeatherType.FOG, convertedType);
    }
}