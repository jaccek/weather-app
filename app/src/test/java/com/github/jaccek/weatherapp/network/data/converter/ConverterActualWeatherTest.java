package com.github.jaccek.weatherapp.network.data.converter;

import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.WeatherType;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.data.RawWeatherDay;
import com.github.jaccek.weatherapp.network.data.RawWeatherData;
import com.github.jaccek.weatherapp.network.data.RawWeatherPeriod;
import com.github.jaccek.weatherapp.testutils.FileLoader;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 9/29/16.
 */
public class ConverterActualWeatherTest
{
    private ConverterActualWeather mConverter;

    @Before
    public void init()
    {
        mConverter = new ConverterActualWeather();
    }

    @Test(expected = ExceptionConversion.class)
    public void testConvertNull() throws ExceptionConversion
    {
        mConverter.convert(null, Calendar.getInstance());
    }

    @Test(expected = ExceptionConversion.class)
    public void testConvertTooEarlyDate() throws Exception
    {
        RawWeatherData rawWeatherData = getRawWeatherData();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);

        mConverter.convert(rawWeatherData, calendar);
    }

    @Test(expected = ExceptionConversion.class)
    public void testConvertTooLateDate() throws Exception
    {
        RawWeatherData rawWeatherData = getRawWeatherData();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2200);

        mConverter.convert(rawWeatherData, calendar);
    }

    @Test
    public void testConvertCorrect() throws Exception
    {
        RawWeatherData rawWeatherData = getRawWeatherData();
        RawWeatherDay rawDay = rawWeatherData.getDays().get(0);
        RawWeatherPeriod rawWeatherPeriod = rawDay.getWeatherPeriods().get(1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(rawWeatherPeriod.getTimestamp() + 1000L);

        ActualWeatherData convertedWeather = mConverter.convert(rawWeatherData, calendar);

        assertEquals(rawWeatherPeriod.getTemperature(), convertedWeather.getTemperature());
        assertEquals(rawWeatherPeriod.getPressure(), convertedWeather.getPressure());
        assertEquals(rawDay.getSunriseHour().getHour(), convertedWeather.getSunriseHour().getHour());
        assertEquals(rawDay.getSunriseHour().getMinutes(), convertedWeather.getSunriseHour().getMinutes());
        assertEquals(rawDay.getSunsetHour().getHour(), convertedWeather.getSunsetHour().getHour());
        assertEquals(rawDay.getSunsetHour().getMinutes(), convertedWeather.getSunsetHour().getMinutes());
        assertEquals(WeatherType.RAIN, convertedWeather.getWeatherType());
    }

    private RawWeatherData getRawWeatherData() throws Exception
    {
        String rawWeatherDataString = FileLoader.loadFile("wpWeatherForecastResponse.json");
        Gson gson = new Gson();
        return gson.fromJson(rawWeatherDataString, RawWeatherData.class);
    }
}