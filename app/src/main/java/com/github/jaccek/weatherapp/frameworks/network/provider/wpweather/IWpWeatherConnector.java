package com.github.jaccek.weatherapp.frameworks.network.provider.wpweather;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit connector for WP weather endpoints.
 */
public interface IWpWeatherConnector
{
    @GET("cityweather")
    Call<WpWeatherForecast> getWeather(@Query("mid") int pCityId);
}
