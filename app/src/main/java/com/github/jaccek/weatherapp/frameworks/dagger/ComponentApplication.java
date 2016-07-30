package com.github.jaccek.weatherapp.frameworks.dagger;

import com.github.jaccek.weatherapp.logic.database.IManagerData;
import com.github.jaccek.weatherapp.logic.presenter.actualweather.PresenterActualWeather;

import dagger.Component;

/**
 * Dagger's component for application.
 */
@Component(modules = ModuleApplication.class)
public interface ComponentApplication
{
    IManagerData getManagerData();

    PresenterActualWeather getPresenterActualWeather();
}
