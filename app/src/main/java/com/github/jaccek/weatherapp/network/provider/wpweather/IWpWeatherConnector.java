package com.github.jaccek.weatherapp.network.provider.wpweather;

import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit connector for WP weather endpoints.
 */
public interface IWpWeatherConnector
{
    @GET("cityweather")
    Call<WpWeatherData> getWeather(@Query("mid") int pCityId);
}
