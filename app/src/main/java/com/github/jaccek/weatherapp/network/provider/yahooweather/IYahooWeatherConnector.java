package com.github.jaccek.weatherapp.network.provider.yahooweather;

import com.github.jaccek.weatherapp.network.data.yahooweather.YahooWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit connector to Yahoo Weather api.
 */
public interface IYahooWeatherConnector
{
    @GET("yql")
    Call<YahooWeatherData> getWeather(
            @Query("q") String pCityQuery,
            @Query("format") String pFormat);
}
