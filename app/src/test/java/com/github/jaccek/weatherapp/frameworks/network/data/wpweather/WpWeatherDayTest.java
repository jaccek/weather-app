package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import com.github.jaccek.weatherapp.helpers.ForecastLoader;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

/**
 * Created by jacek on 8/10/16.
 */
public class WpWeatherDayTest
{
    private WpWeatherDay mWpWeatherDay;
    private Calendar mDay;

    @Before
    public void init()
    {
        WpWeatherForecast forecast = ForecastLoader.getWpWeatherForecast();
        mDay = ForecastLoader.getDateOfWpWeatherForecast();
        mWpWeatherDay = forecast.getWeatherDay(mDay);
    }

    @Test
    public void getWeatherDataTestEmptyData()
    {
        mWpWeatherDay.setWeather(null);
        assertTrue(mWpWeatherDay.getWeatherData(mDay) == null);
    }

    @Test
    public void getWeatherDataTestDateOutOfRange()
    {
        mDay.add(Calendar.MONTH, 1);
        assertTrue(mWpWeatherDay.getWeatherData(mDay) == null);
    }

    @Test
    public void getWeatherDataTestCorrectDate()
    {
        WpWeatherData data = mWpWeatherDay.getWeatherData(mDay);
        assertTrue(data.equals(mWpWeatherDay.getWeather().get(0)));
    }
}