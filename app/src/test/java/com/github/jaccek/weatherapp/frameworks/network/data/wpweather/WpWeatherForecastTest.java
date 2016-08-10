package com.github.jaccek.weatherapp.frameworks.network.data.wpweather;

import com.github.jaccek.weatherapp.helpers.ForecastLoader;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 8/9/16.
 */
public class WpWeatherForecastTest
{
    @Test
    public void getWeatherDayNoData()
    {
        WpWeatherForecast forecast = new WpWeatherForecast();

        assertEquals(null, forecast.getWeatherDay(Calendar.getInstance()));
    }

    @Test
    public void getWeatherDayCorrect()
    {
        WpWeatherForecast forecast = ForecastLoader.getWpWeatherForecast();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.AUGUST, 12, 1, 21);

        WpWeatherDay expected = forecast.getDays().get(2);

        assertEquals(expected, forecast.getWeatherDay(calendar));
    }
}