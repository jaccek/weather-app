package com.github.jaccek.weatherapp.actualweather.dagger;

import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.network.data.converter.ConverterActualWeather;
import com.github.jaccek.weatherapp.network.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.network.retrofit.NetworkConnectorRetrofit;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

/**
 * Created by jacek on 9/26/16.
 */
@Module
public class ModuleActualWeather
{
    @Provides
    ConnectorActualWeather provideConnector()
    {
        return new NetworkConnectorRetrofit();
    }

    @Provides
    @Reusable
    ConverterCity provideConverterCity()
    {
        return new ConverterCity();
    }

    @Provides
    @Reusable
    ConverterActualWeather provideConverterActualWeather()
    {
        return new ConverterActualWeather();
    }
}
