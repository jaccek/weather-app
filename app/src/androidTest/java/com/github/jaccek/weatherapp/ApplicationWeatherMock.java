package com.github.jaccek.weatherapp;

import com.github.jaccek.weatherapp.dagger.TestModuleActualWeather;
import com.github.jaccek.weatherapp.dagger.ApplicationComponent;
import com.github.jaccek.weatherapp.dagger.DaggerApplicationComponent;

/**
 * Created by jacek on 9/26/16.
 */

public class ApplicationWeatherMock extends ApplicationWeather
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        ApplicationComponent component = DaggerApplicationComponent.builder()
                .moduleActualWeather(new TestModuleActualWeather())
                .build();
        setComponent(component);
    }
}
