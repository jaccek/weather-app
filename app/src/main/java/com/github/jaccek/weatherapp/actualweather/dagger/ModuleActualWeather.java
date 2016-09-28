package com.github.jaccek.weatherapp.actualweather.dagger;

import com.github.jaccek.weatherapp.actualweather.ContractActualWeather;
import com.github.jaccek.weatherapp.actualweather.PresenterActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.DataCollectorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.InteractorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;
import com.github.jaccek.weatherapp.network.data.converter.ConverterActualWeather;
import com.github.jaccek.weatherapp.network.data.converter.ConverterCity;
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
    ThreadRunnerStrategy provideThredRunnerStrategy()
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
