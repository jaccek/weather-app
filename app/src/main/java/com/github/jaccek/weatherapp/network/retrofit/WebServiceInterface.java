package com.github.jaccek.weatherapp.network.retrofit;

import com.github.jaccek.weatherapp.network.models.RawCitiesList;
import com.github.jaccek.weatherapp.network.models.RawWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jacek on 8/21/16.
 */
public interface WebServiceInterface
{
    @GET("citieslist")
    Call<RawCitiesList> downloadCities();

    @GET("city")
    Call<RawWeatherData> downloadWeatherData(@Query("cid") int pCityId);
}
