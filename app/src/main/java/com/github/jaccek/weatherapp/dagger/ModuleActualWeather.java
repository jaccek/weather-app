package com.github.jaccek.weatherapp.dagger;

import com.github.jaccek.weatherapp.contracts.ContractActualWeather;
import com.github.jaccek.weatherapp.presenters.PresenterActualWeather;
import com.github.jaccek.weatherapp.managers.DataCollectorActualWeather;
import com.github.jaccek.weatherapp.interactors.InteractorActualWeather;
import com.github.jaccek.weatherapp.network.connectors.ConnectorActualWeather;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;
import com.github.jaccek.weatherapp.network.models.converter.ConverterActualWeather;
import com.github.jaccek.weatherapp.network.models.converter.ConverterCity;
import com.github.jaccek.weatherapp.network.retrofit.NetworkConnectorRetrofit;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategyImpl;

import javax.inject.Singleton;

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
    ContractActualWeather.Presenter providePresenter(ContractActualWeather.Interactor pInteractor)
    {
        return new PresenterActualWeather(pInteractor);
    }

    @Provides
    ContractActualWeather.Interactor provideInteractor(ThreadRunnerStrategy pThreadRunner,
                                                       DataCollectorActualWeather pDataCollector)
    {
        return new InteractorActualWeather(pThreadRunner, pDataCollector);
    }

    @Provides
    @Singleton
    ThreadRunnerStrategy provideThreadRunnerStrategy()
    {
        return new ThreadRunnerStrategyImpl();
    }

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
