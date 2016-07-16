package com.github.jaccek.weatherapp.logic.view.actualweather;

import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherData;

/**
 * Created by jacek on 7/9/16.
 */
public interface ViewActualWeather
{
    void showWeather(IWeatherData pWeatherData);

    void startActivityNextWeek();

    void startActivityChooseCity();
}
