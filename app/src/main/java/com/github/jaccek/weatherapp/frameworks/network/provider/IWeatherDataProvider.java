package com.github.jaccek.weatherapp.frameworks.network.provider;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherForecast;

/**
 * Interface for any data provider.
 */
public interface IWeatherDataProvider
{
    IWeatherForecast getWeatherForecast() throws Exception;
}
