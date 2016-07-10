package com.github.jaccek.weatherapp.network.provider.wpweather;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherData;
import com.github.jaccek.weatherapp.network.provider.IWeatherDataProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

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
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mConnector = retrofit.create(IWpWeatherConnector.class);
    }

    @Override
    public IWeatherData getWeatherData() throws IOException
    {
        Response<WpWeatherData> response = mConnector.getWeather(1201290).execute();
        if (response.code() != 200)
        {
            throw new IOException("Connection error (http code: " + response.code() + ")");
        }
        return response.body();
    }
}
