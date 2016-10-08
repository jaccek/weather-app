package com.github.jaccek.weatherapp.choosecity;

import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.network.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;

import java.util.ArrayList;
import java.util.List;

public class InteractorChooseCity implements
        ContractChooseCity.Interactor
{
    private ConverterCity mConverterCity;
    private ThreadRunnerStrategy mThreadRunner;
    private DataCollectorChooseCity mDataCollector;
    private ContractChooseCity.PresenterForInteractor mPresenter;

    public InteractorChooseCity(ThreadRunnerStrategy pThreadRunner,
                                DataCollectorChooseCity pDataCollector,
                                ConverterCity pConverterCity)
    {
        mThreadRunner = pThreadRunner;
        mDataCollector = pDataCollector;
        mConverterCity = pConverterCity;
    }

    @Override
    public void setPresenter(ContractChooseCity.PresenterForInteractor pPresenter)
    {
        mPresenter = pPresenter;
    }

    @Override
    public void queryCities()
    {
        mThreadRunner.executeInBackground(new Runnable()
        {
            @Override
            public void run()
            {
                queryCitiesInBackground();
            }
        });
    }

    private void queryCitiesInBackground()
    {
        List<RawCity> rawCities = mDataCollector.getCities();

        final List<City> convertedCities = new ArrayList<>();
        for (RawCity rawCity : rawCities)
        {
            try
            {
                City city = mConverterCity.convert(rawCity);
                convertedCities.add(city);
            }
            catch(ExceptionConversion pException)
            {
                pException.printStackTrace();
                // just ignore this city
            }
        }

        mThreadRunner.executeInMainThread(new Runnable()
        {
            @Override
            public void run()
            {
                deliverCitiesInUi(convertedCities);
            }
        });
    }

    private void deliverCitiesInUi(List<City> pCities)
    {
        mPresenter.onCities(pCities);
    }
}
