package com.github.jaccek.weatherapp.frameworks.dagger;

import com.github.jaccek.weatherapp.frameworks.database.ManagerData;
import com.github.jaccek.weatherapp.frameworks.network.provider.IWeatherDataProvider;
import com.github.jaccek.weatherapp.frameworks.network.provider.wpweather.WpWeatherProvider;
import com.github.jaccek.weatherapp.logic.database.IManagerData;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger's module to provide objects.
 */
@Module
public class ModuleApplication
{
    @Provides
    static IWeatherDataProvider provideDataProvider()
    {
        return new WpWeatherProvider();
    }

    @Provides
    static IManagerData provideManagerData()
    {
        return new ManagerData();
    }
}
