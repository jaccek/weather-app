package com.github.jaccek.weatherapp.actualweather;

import com.github.jaccek.weatherapp.data.ActualWeatherData;
import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.utils.contract.PresenterBase;

/**
 * Created by jacek on 8/20/16.
 */
public interface ContractActualWeather
{
    interface View
    {
        void showCity(City pCity);

        void showWeather(ActualWeatherData pWeatherData);

        void showLoader();

        void showConnectionError();
    }

    interface Interactor
    {
        void requestUserCity(PresenterForInteractor pPresenter);

        void requestActualWeatherData(PresenterForInteractor pPresenter, City pCity);
    }

    interface Router
    {
        void startNextDaysActivity();

        void startChangeCityActivity(PresenterForRouter pPresenter, City pSelectedCity);
    }

    interface Presenter extends PresenterBase<View, Router>
    {
        void onCreate();

        void onCityClicked();

        void onNextDaysButtonClicked();
    }

    interface PresenterForInteractor
    {
        void onCity(City pCity);

        void onActualWeatherData(ActualWeatherData pWeatherData);

        void onConnectionError();
    }

    interface PresenterForRouter
    {
        void onCityChanged(City pCity);
    }
}
