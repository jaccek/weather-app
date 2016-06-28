package com.github.jaccek.weatherapp.network.provider;

import com.github.jaccek.weatherapp.network.data.IWeatherData;

import java.io.IOException;

/**
 * Interface for any data provider.
 */
public interface WeatherDataProvider
{
    IWeatherData getWeatherData() throws IOException;
}
