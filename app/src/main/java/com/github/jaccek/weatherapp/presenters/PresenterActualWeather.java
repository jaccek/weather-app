package com.github.jaccek.weatherapp.presenters;

import com.github.jaccek.weatherapp.contracts.ContractActualWeather;
import com.github.jaccek.weatherapp.models.ActualWeatherData;
import com.github.jaccek.weatherapp.models.City;

/**
 * Responsibility: merge all components of actual weather module
 */
public class PresenterActualWeather implements
        ContractActualWeather.Presenter,
        ContractActualWeather.PresenterForRouter,
        ContractActualWeather.PresenterForInteractor
{
    private ContractActualWeather.View mView;
    private ContractActualWeather.Router mRouter;
    private ContractActualWeather.Interactor mInteractor;

    private City mSelectedCity;

    public PresenterActualWeather(
            ContractActualWeather.Interactor pInteractor)
    {
        mInteractor = pInteractor;
    }

    @Override
    public void init(ContractActualWeather.View pView, ContractActualWeather.Router pRouter)
    {
        mView = pView;
        mRouter = pRouter;
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
        mRouter.startChangeCityActivity(this, mSelectedCity);
    }

    @Override
    public void onNextDaysButtonClicked()
    {
        mRouter.startNextDaysActivity();
    }

    @Override
    public void onCityChanged(City pCity)
    {
        mSelectedCity = pCity;
        mView.showCity(pCity);
        mView.showLoader();
        mInteractor.requestActualWeatherData(this, pCity);
    }

    @Override
    public void onCity(City pCity)
    {
        onCityChanged(pCity);
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
