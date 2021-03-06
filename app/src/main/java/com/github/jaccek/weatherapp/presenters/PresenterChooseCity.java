package com.github.jaccek.weatherapp.presenters;

import com.github.jaccek.weatherapp.contracts.ContractChooseCity;
import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.utils.StringHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacek on 10/8/16.
 */

public class PresenterChooseCity implements
        ContractChooseCity.Presenter,
        ContractChooseCity.PresenterForInteractor
{
    private ContractChooseCity.Interactor mInteractor;
    private ContractChooseCity.Router mRouter;
    private ContractChooseCity.View mView;

    private List<City> mCities;

    public PresenterChooseCity(ContractChooseCity.Interactor pInteractor)
    {
        mInteractor = pInteractor;
        mInteractor.setPresenter(this);
    }

    @Override
    public void init(ContractChooseCity.View pView, ContractChooseCity.Router pRouter)
    {
        mView = pView;
        mRouter = pRouter;
    }

    @Override
    public void onCreate()
    {
        mView.showLoader();
        mInteractor.queryCities();
    }

    @Override
    public void onCitySelected(City pCity)
    {
        mRouter.backToActualWeather(pCity);
    }

    @Override
    public void onSearchIconClicked()
    {
        mView.showSearcher();
    }

    @Override
    public void onSearchQueryChanged(String pQuery)
    {
        List<City> filteredCities = getFilteredCities(pQuery);
        mView.showCities(filteredCities);
    }

    private List<City> getFilteredCities(String pQuery)
    {
        String normalizedQuery = StringHelper.normalize(pQuery);
        List<City> filteredCities = new ArrayList<>();
        for(City city : mCities)
        {
            if (StringHelper.normalize(city.getName()).contains(normalizedQuery))
            {
                filteredCities.add(city);
            }
        }
        return filteredCities;
    }

    @Override
    public void onCities(List<City> pCities)
    {
        mCities = pCities;
        mView.showCities(mCities);
    }

    @Override
    public void onError()
    {
        mView.showError();
    }
}
