package com.github.jaccek.weatherapp.actualweather;

import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;

/**
 * Created by jacek on 8/20/16.
 */
public class PresenterActualWeather implements
        ContractActualWeather.Presenter,
        ContractActualWeather.PresenterForRouter,
        ContractActualWeather.PresenterForInteractor
{
    private ContractActualWeather.View mView;
    private ContractActualWeather.Router mRouter;
    private ContractActualWeather.Interactor mInteractor;

    public PresenterActualWeather(
            ContractActualWeather.View pView,
            ContractActualWeather.Router pRouter,
            ContractActualWeather.Interactor pInteractor)
    {
        mView = pView;
        mRouter = pRouter;
        mInteractor = pInteractor;
    }

    @Override
    public void onCreate()
    {
        mView.showLoader();
        mInteractor.requestUserCity(this);
    }

    @Override
    public void onCityClicked()
    {
        mRouter.startChangeCityActivity(this);
    }

    @Override
    public void onNextDaysButtonClicked()
    {
        mRouter.startNextDaysActivity();
    }

    @Override
    public void onCityChanged(City pCity)
    {
        mView.showCity(pCity);
        mView.showLoader();
        mInteractor.requestActualWeatherData(this, pCity);
    }

    @Override
    public void onActualWeatherData(ActualWeatherData pWeatherData)
    {
        mView.showWeather(pWeatherData);
    }

    @Override
    public void onConnectionError()
    {
        mView.showConnectionError();
    }
}
