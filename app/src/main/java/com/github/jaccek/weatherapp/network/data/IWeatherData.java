package com.github.jaccek.weatherapp.network.data;

/**
 * Interface for object returned by any weather api.
 */
public interface IWeatherData
{
    /**
     * Type of weather
     */
    enum WeatherType
    {
        SUNNY,
        CLOUDY,
        MOSTLY_CLOUDY,
        FOGGY,
        RAINY,
        SNOW,
        STORM,
        UNKNOWN
    }

    float getWindSpeed();
    int getTemperature();

    WeatherType getWeatherType();
}
