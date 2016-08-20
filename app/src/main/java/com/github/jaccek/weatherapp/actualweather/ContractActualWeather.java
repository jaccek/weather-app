package com.github.jaccek.weatherapp.actualweather;

import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;

/**
 * Created by jacek on 8/20/16.
 */
public class ContractActualWeather
{
    public interface View
    {
        void showWeather(ActualWeatherData pWeatherData);
        void showLoader();
        void showConnectionError();
    }

    public interface Interactor
    {
        void requestUserCity(PresenterForInteractor pPresenter);
        void requestActualWeatherData(PresenterForInteractor pPresenter, City pCity);
    }

    public interface Router
    {
        void startNextDaysActivity();
        void startChangeCityActivity(PresenterForRouter pPresenter);
    }

    public interface Presenter
    {
        void onCityClicked();
        void onNextDaysButtonClicked();
    }

    public interface PresenterForInteractor
    {
        void onActualWeatherData(ActualWeatherData pWeatherData);
        void onConnectionError();
    }

    public interface PresenterForRouter
    {
        void onCityChanged(City pCity);
    }
}
