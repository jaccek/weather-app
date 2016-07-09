package com.github.jaccek.weatherapp.weather.actual;

import com.github.jaccek.weatherapp.network.data.IWeatherData;

/**
 * Created by jacek on 7/9/16.
 */
public interface ViewActualWeather
{
    void showWeather(IWeatherData pWeatherData);

    void startActivityNextWeek();

    void startActivityChooseCity();
}
