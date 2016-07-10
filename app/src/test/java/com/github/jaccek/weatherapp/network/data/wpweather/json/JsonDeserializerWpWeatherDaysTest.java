package com.github.jaccek.weatherapp.network.data.wpweather.json;

import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherDay;
import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherForecast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Tests for {@link JsonDeserializerWpWeatherDays}.
 */
public class JsonDeserializerWpWeatherDaysTest
{
    @Test
    public void deserializeTestNonNullDays() throws Exception
    {
        WpWeatherForecast forecast = getWpWeatherForecastFromJson();
        assertNotNull(forecast.getDays());
    }

    @Test
    public void deserializeTestNumberOfDays() throws Exception
    {
        WpWeatherForecast forecast = getWpWeatherForecastFromJson();
        assertEquals(7, forecast.getDays().size());
    }

    private WpWeatherForecast getWpWeatherForecastFromJson()
    {
        Type listType = new TypeToken<List<WpWeatherDay>>() {}.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(listType, new JsonDeserializerWpWeatherDays())
                .create();

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("wpWeatherForecastResponse.json");
        InputStreamReader reader = new InputStreamReader(inputStream);
        return gson.fromJson(reader, WpWeatherForecast.class);
    }
}