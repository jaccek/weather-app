package com.github.jaccek.weatherapp.network.data;

/**
 * Objects implementing this interface store weather data for one day.
 */
public interface IWeatherDay
{
    boolean isToday();

    long getSunriseTimestamp();
    long getSunsetTimestamp();
}
