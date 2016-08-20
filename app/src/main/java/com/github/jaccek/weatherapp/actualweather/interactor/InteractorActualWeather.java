package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.actualweather.ContractActualWeather;
import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.actualweather.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawCity;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.ThreadRunnerStrategy;

import java.lang.ref.WeakReference;

/**
 * Responsibility: running new threads to get data for actual weather module
 *
 * TODO: now it has also responsibility to download data from network - must be separated!
 */
public class InteractorActualWeather implements
        ContractActualWeather.Interactor
{
    private ThreadRunnerStrategy mThreadRunner;
    private ConnectorActualWeather mConnector;
    private ConverterCity mConverter;

    public InteractorActualWeather(ThreadRunnerStrategy pThreadRunner,
                                   ConnectorActualWeather pConnector,
                                   ConverterCity pConverter)
    {
        mThreadRunner = pThreadRunner;
        mConnector = pConnector;
        mConverter = pConverter;
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
                requestUserCityInBackground(pPresenterReference);
            }
        });
    }

    private void requestUserCityInBackground(final WeakReference<ContractActualWeather.PresenterForInteractor> pPresenter)
    {
        try
        {
            getUserCity(pPresenter);
        }
        catch(ExceptionNetwork | ExceptionConversion pException)
        {
            handleRequestUserCityFail(pPresenter, pException);
        }
    }

    private void getUserCity(final WeakReference<ContractActualWeather.PresenterForInteractor> pPresenter)
            throws ExceptionNetwork, ExceptionConversion
    {
        // TODO: city id of Warsaw - change it
        RawCity rawCity = mConnector.downloadCity(43116);
        final City city = mConverter.convert(rawCity);
        mThreadRunner.executeInMainThread(new Runnable()
        {
            @Override
            public void run()
            {
                onRequestUserCityEnd(pPresenter, city);
            }
        });
    }

    private void handleRequestUserCityFail(final WeakReference<ContractActualWeather.PresenterForInteractor> pPresenter,
                                           Exception pException)
    {
        pException.printStackTrace();
        mThreadRunner.executeInMainThread(new Runnable()
        {
            @Override
            public void run()
            {
                onRequestCityFailed(pPresenter);
            }
        });
    }

    private void onRequestCityFailed(WeakReference<ContractActualWeather.PresenterForInteractor> pPresenter)
    {
        ContractActualWeather.PresenterForInteractor pPresenterHard = pPresenter.get();
        if(pPresenterHard != null)
        {
            pPresenterHard.onConnectionError();
        }
    }

    private void onRequestUserCityEnd(WeakReference<ContractActualWeather.PresenterForInteractor> pPresenter, City pCity)
    {
        ContractActualWeather.PresenterForInteractor pPresenterHard = pPresenter.get();
        if(pPresenterHard != null)
        {
            pPresenterHard.onCity(pCity);
        }
    }

    @Override
    public void requestActualWeatherData(ContractActualWeather.PresenterForInteractor pPresenter, City pCity)
    {

    }
}
