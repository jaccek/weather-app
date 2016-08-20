package com.github.jaccek.weatherapp.actualweather;

import com.github.jaccek.weatherapp.actualweather.data.City;

/**
 * Created by jacek on 8/20/16.
 */
public class PresenterActualWeather implements
        ContractActualWeather.Presenter,
        ContractActualWeather.PresenterForRouter
{
    private ContractActualWeather.Router mRouter;

    public PresenterActualWeather(ContractActualWeather.Router pRouter)
    {
        mRouter = pRouter;
    }

    @Override
    public void onCityClicked()
    {
        mRouter.startChangeCityActivity(this);
    }

    @Override
    public void onNextDaysButtonClicked()
    {

    }

    @Override
    public void onCityChanged(City pCity)
    {

    }
}
