package com.github.jaccek.weatherapp.actualweather.dagger;

import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;

import dagger.Module;

import static org.mockito.Mockito.mock;

/**
 * Created by jacek on 9/26/16.
 */
@Module
public class TestModuleActualWeather extends ModuleActualWeather
{
    @Override
    ConnectorActualWeather provideConnector()
    {
        return mock(ConnectorActualWeather.class);
    }
}
