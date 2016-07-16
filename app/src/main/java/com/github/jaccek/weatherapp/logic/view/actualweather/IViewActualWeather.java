package com.github.jaccek.weatherapp.logic.view.actualweather;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;

/**
 * View interface for actual weather
 */
public interface IViewActualWeather
{
    void showWeather(WeatherDataActual pWeatherData);

    void startActivityNextWeek();

    void startActivityChooseCity();

    void showConnectionError();
}
