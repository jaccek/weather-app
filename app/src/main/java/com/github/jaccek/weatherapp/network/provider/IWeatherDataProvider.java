package com.github.jaccek.weatherapp.network.provider;

import com.github.jaccek.weatherapp.network.data.IWeatherData;

import java.io.IOException;

/**
 * Interface for any data provider.
 */
public interface IWeatherDataProvider
{
    IWeatherData getWeatherData() throws IOException;
}
