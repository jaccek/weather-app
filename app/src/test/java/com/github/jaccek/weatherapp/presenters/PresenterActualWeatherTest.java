package com.github.jaccek.weatherapp.presenters;

import com.github.jaccek.weatherapp.contracts.ContractActualWeather;
import com.github.jaccek.weatherapp.models.ActualWeatherData;
import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.presenters.PresenterActualWeather;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

/**
 * Created by jacek on 8/20/16.
 */
public class PresenterActualWeatherTest
{
    PresenterActualWeather mPresenter;
    @Mock
    ContractActualWeather.View mView;
    @Mock
    ContractActualWeather.Router mRouter;
    @Mock
    ContractActualWeather.Interactor mInteractor;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mPresenter = new PresenterActualWeather(mInteractor);
        mPresenter.init(mView, mRouter);
    }

    @Test
    public void testOnCreate()
    {
        mPresenter.onCreate();

        verify(mView).showLoader();
        verify(mInteractor).requestUserCity(mPresenter);
    }

    @Test
    public void testOnCityClicked()
    {
        City city = new City();
        mPresenter.onCity(city);

        mPresenter.onCityClicked();

        verify(mRouter).startChangeCityActivity(mPresenter, city);
    }

    @Test
    public void testOnNextDaysButtonClicked()
    {
        mPresenter.onNextDaysButtonClicked();
        verify(mRouter).startNextDaysActivity();
    }

    @Test
    public void testOnCityChanged()
    {
        City city = new City();
        mPresenter.onCityChanged(city);
        verifyOnCity(city);
    }

    @Test
    public void testOnCity()
    {
        City city = new City();
        mPresenter.onCity(city);
        verifyOnCity(city);
    }

    private void verifyOnCity(City pCity)
    {
        verify(mView).showCity(pCity);
        verify(mView).showLoader();
        verify(mInteractor).requestActualWeatherData(mPresenter, pCity);
    }

    @Test
    public void testOnActualWeatherData()
    {
        ActualWeatherData data = new ActualWeatherData();
        mPresenter.onActualWeatherData(data);
        verify(mView).showWeather(data);
    }

    @Test
    public void testOnConnectionError()
    {
        mPresenter.onConnectionError();
        verify(mView).showConnectionError();
    }
}