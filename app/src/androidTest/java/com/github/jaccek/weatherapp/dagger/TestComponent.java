package com.github.jaccek.weatherapp.dagger;

import com.github.jaccek.weatherapp.actualweather.dagger.TestModuleActualWeather;

import dagger.Component;

/**
 * Created by jacek on 9/26/16.
 */
@Component(modules = TestModuleActualWeather.class)
public interface TestComponent extends ApplicationComponent
{
}
