package com.github.jaccek.weatherapp.network.connectors;

import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.models.RawCity;
import com.github.jaccek.weatherapp.network.models.RawWeatherData;

import java.util.List;

/**
 * Created by jacek on 8/20/16.
 */
public interface ConnectorActualWeather
{
    List<RawCity> downloadCities() throws ExceptionNetwork;

    RawWeatherData downloadWeatherData(int pCityId) throws ExceptionNetwork;
}
