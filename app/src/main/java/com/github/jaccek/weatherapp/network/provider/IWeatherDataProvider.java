package com.github.jaccek.weatherapp.network.provider;

import com.github.jaccek.weatherapp.network.data.IWeatherForecast;

/**
 * Interface for any data provider.
 */
public interface IWeatherDataProvider
{
    IWeatherForecast getWeatherForecast() throws Exception;
}
