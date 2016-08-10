package com.github.jaccek.weatherapp.helpers;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherDay;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;

/**
 * Created by jacek on 8/6/16.
 */
public class ForecastLoader
{
    public static WpWeatherForecast getWpWeatherForecast()
    {
        Type listType = new TypeToken<List<WpWeatherDay>>() {}.getType();
        Gson gson = new GsonBuilder()
                .create();

        InputStream inputStream = ForecastLoader.class
                .getClassLoader()
                .getResourceAsStream("wpWeatherForecastResponse.json");
        InputStreamReader reader = new InputStreamReader(inputStream);
        return gson.fromJson(reader, WpWeatherForecast.class);
    }

    public static Calendar getDateOfWpWeatherForecast()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.AUGUST, 11, 12, 30);
        return calendar;
    }
}
