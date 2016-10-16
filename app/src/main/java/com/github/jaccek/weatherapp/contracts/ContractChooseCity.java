package com.github.jaccek.weatherapp.contracts;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.utils.contract.PresenterBase;

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

        void showSearcher();

        void showError();
    }

    interface Presenter extends PresenterBase<View, Router>
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

    interface Interactor
    {
        void setPresenter(PresenterForInteractor pPresenter);

        void queryCities();
    }

    interface Router
    {
        void backToActualWeather(@Nullable City pSelectedCity);
    }
}
