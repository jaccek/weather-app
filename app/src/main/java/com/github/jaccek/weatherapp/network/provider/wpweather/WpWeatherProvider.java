package com.github.jaccek.weatherapp.network.provider.wpweather;

import com.github.jaccek.weatherapp.network.data.IWeatherForecast;
import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherDay;
import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherForecast;
import com.github.jaccek.weatherapp.network.data.wpweather.json.JsonDeserializerWpWeatherDays;
import com.github.jaccek.weatherapp.network.provider.IWeatherDataProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * WP weather provider.
 */
public class WpWeatherProvider implements IWeatherDataProvider
{
    private static final String BASE_URL = "http://pogoda.wp.pl/app/";
    private final IWpWeatherConnector mConnector;

    public WpWeatherProvider()
    {
        Type dayListType = new TypeToken<List<WpWeatherDay>>() {}.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(dayListType, new JsonDeserializerWpWeatherDays())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mConnector = retrofit.create(IWpWeatherConnector.class);
    }

    @Override
    public IWeatherForecast getWeatherForecast() throws Exception
    {
        Response<WpWeatherForecast> response = mConnector.getWeather(1201290).execute();
        if (response.code() != 200)
        {
            throw new IOException("Connection error (http code: " + response.code() + ")");
        }
        return response.body();
    }
}
