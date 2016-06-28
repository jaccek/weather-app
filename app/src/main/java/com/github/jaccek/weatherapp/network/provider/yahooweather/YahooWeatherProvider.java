package com.github.jaccek.weatherapp.network.provider.yahooweather;

import com.github.jaccek.weatherapp.network.EndpointConfig;
import com.github.jaccek.weatherapp.network.data.yahooweather.YahooWeatherData;
import com.github.jaccek.weatherapp.network.data.yahooweather.json.YahooWeatherDataDeserializer;
import com.github.jaccek.weatherapp.network.provider.WeatherDataProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Data provider from Yahoo Weather api.
 */
public class YahooWeatherProvider implements WeatherDataProvider
{
    private final YahooWeatherConnector mProvider;

    public YahooWeatherProvider()
    {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(YahooWeatherData.class, new YahooWeatherDataDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EndpointConfig.YAHOO_WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mProvider = retrofit.create(YahooWeatherConnector.class);
    }

    @Override
    public YahooWeatherData getWeatherData() throws IOException
    {
        Call<YahooWeatherData> call = mProvider.getWeather("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"nome, ak\")", "json");
        Response<YahooWeatherData> response = call.execute();

        if (response.code() != 200)
        {
            throw new IOException("Response http code: " + response.code());
        }

        return response.body();
    }
}
