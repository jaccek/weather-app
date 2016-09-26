package com.github.jaccek.weatherapp.dagger;

import com.github.jaccek.weatherapp.actualweather.dagger.ModuleActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.DataCollectorActualWeather;

import dagger.Component;

/**
 * Created by jacek on 9/26/16.
 */
@Component(modules = ModuleActualWeather.class)
public interface ApplicationComponent
{
    DataCollectorActualWeather getDataCollectorActualWeather();
}
