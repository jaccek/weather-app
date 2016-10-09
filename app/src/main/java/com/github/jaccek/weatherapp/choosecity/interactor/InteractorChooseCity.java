package com.github.jaccek.weatherapp.choosecity.interactor;

import com.github.jaccek.weatherapp.choosecity.ContractChooseCity;
import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;

import java.util.List;

public class InteractorChooseCity implements
        ContractChooseCity.Interactor
{
    private ThreadRunnerStrategy mThreadRunner;
    private DataCollectorChooseCity mDataCollector;
    private ContractChooseCity.PresenterForInteractor mPresenter;

    public InteractorChooseCity(ThreadRunnerStrategy pThreadRunner,
                                DataCollectorChooseCity pDataCollector)
    {
        mThreadRunner = pThreadRunner;
        mDataCollector = pDataCollector;
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
        try
        {
            final List<City> cities = mDataCollector.getCities();
            mThreadRunner.executeInMainThread(new Runnable()
            {
                @Override
                public void run()
                {
                    deliverCitiesInUi(cities);
                }
            });
        }
        catch(ExceptionNetwork pExceptionNetwork)
        {
            pExceptionNetwork.printStackTrace();
            mThreadRunner.executeInMainThread(new Runnable()
            {
                @Override
                public void run()
                {
                    deliverExceptionInUi();
                }
            });
        }
    }

    private void deliverCitiesInUi(List<City> pCities)
    {
        mPresenter.onCities(pCities);
    }

    private void deliverExceptionInUi()
    {
        mPresenter.onError();
    }
}
