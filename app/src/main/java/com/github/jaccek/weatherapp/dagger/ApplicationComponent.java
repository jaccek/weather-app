package com.github.jaccek.weatherapp.dagger;

import com.github.jaccek.weatherapp.actualweather.ContractActualWeather;
import com.github.jaccek.weatherapp.actualweather.dagger.ModuleActualWeather;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jacek on 9/26/16.
 */
@Singleton
@Component(modules = ModuleActualWeather.class)
public interface ApplicationComponent
{
    ContractActualWeather.Presenter getActualWeatherPresenter();
}
