package com.github.jaccek.weatherapp.frameworks.network.provider;

import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;

/**
 * Interface for any data provider.
 */
public interface IWeatherDataProvider
{
    WpWeatherForecast getWeatherForecast() throws Exception;
}
