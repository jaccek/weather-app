package com.github.jaccek.weatherapp.actualweather.interactor.network;

import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawCity;
import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawWeatherData;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;

/**
 * Created by jacek on 8/20/16.
 */
public interface ConnectorActualWeather
{
    RawCity downloadCity(int pCityId) throws ExceptionNetwork;

    RawWeatherData downloadWeatherData(int pId);
}
