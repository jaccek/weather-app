package com.github.jaccek.weatherapp.choosecity;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.data.City;

import java.util.List;

/**
 * Created by jacek on 10/3/16.
 */

public interface ContractChooseCity
{
    interface View
    {
        void showLoader();

        void showCities(List<City> pCities);
    }

    interface Presenter
    {
        void onCreate();

        void onCitySelected(City pCity);

        void onSearchIconClicked();

        void onSearchQueryChanged(String pQuery);
    }

    interface PresenterForInteractor
    {
        void onCities(List<City> pCities);

        void onError();
    }

    interface Router
    {
        void backToActualWeather(@Nullable City pSelectedCity);
    }
}
