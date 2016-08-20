package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.actualweather.ContractActualWeather;
import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.network.ThreadRunnerStrategy;

import java.lang.ref.WeakReference;

/**
 * Responsibility: running new threads to get data for actual weather module
 */
public class InteractorActualWeather implements
        ContractActualWeather.Interactor
{
    private ThreadRunnerStrategy mThreadRunner;

    public InteractorActualWeather(ThreadRunnerStrategy pThreadRunner)
    {
        mThreadRunner = pThreadRunner;
    }

    @Override
    public void requestUserCity(ContractActualWeather.PresenterForInteractor pPresenter)
    {
        final WeakReference<ContractActualWeather.PresenterForInteractor> pPresenterReference
                = new WeakReference<>(pPresenter);

        mThreadRunner.executeInBackground(new Runnable()
        {
            @Override
            public void run()
            {
                requestUserCity(pPresenterReference);
            }
        });
    }

    private void requestUserCity(final WeakReference<ContractActualWeather.PresenterForInteractor> pPresenter)
    {
        // TODO:

        mThreadRunner.executeInMainThread(new Runnable()
        {
            @Override
            public void run()
            {
                // TODO: remove null!!!
                onRequestUserCityEnd(pPresenter, null);
            }
        });
    }

    private void onRequestUserCityEnd(WeakReference<ContractActualWeather.PresenterForInteractor> pPresenter, City pCity)
    {
        ContractActualWeather.PresenterForInteractor pPresenterHard = pPresenter.get();
        if (pPresenterHard != null)
        {
            pPresenterHard.onCity(pCity);
        }
    }

    @Override
    public void requestActualWeatherData(ContractActualWeather.PresenterForInteractor pPresenter, City pCity)
    {

    }
}
