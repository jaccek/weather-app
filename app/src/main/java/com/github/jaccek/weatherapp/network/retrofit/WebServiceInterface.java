package com.github.jaccek.weatherapp.network.retrofit;

import com.github.jaccek.weatherapp.network.data.RawCitiesList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jacek on 8/21/16.
 */
public interface WebServiceInterface
{
    @GET("citieslist")
    Call<RawCitiesList> downloadCities();
}
