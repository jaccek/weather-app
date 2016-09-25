package com.github.jaccek.weatherapp.actualweather.interactor.network;

import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.network.data.RawWeatherData;

import java.util.List;

/**
 * Created by jacek on 8/20/16.
 */
public interface ConnectorActualWeather
{
    List<RawCity> downloadCities() throws ExceptionNetwork;

    RawWeatherData downloadWeatherData(int pCityId) throws ExceptionNetwork;
}
