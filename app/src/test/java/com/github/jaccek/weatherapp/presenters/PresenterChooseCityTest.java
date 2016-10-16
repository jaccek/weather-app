package com.github.jaccek.weatherapp.presenters;

import com.github.jaccek.weatherapp.contracts.ContractChooseCity;
import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.presenters.PresenterChooseCity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by jacek on 10/8/16.
 */
public class PresenterChooseCityTest
{
    private PresenterChooseCity mPresenter;
    @Mock
    private ContractChooseCity.Interactor mInteractor;
    @Mock
    private ContractChooseCity.Router mRouter;
    @Mock
    private ContractChooseCity.View mView;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mPresenter = new PresenterChooseCity(mInteractor);
        mPresenter.init(mView, mRouter);
    }

    @Test
    public void testOnCreate()
    {
        mPresenter.onCreate();

        verify(mView).showLoader();
        verify(mInteractor).setPresenter(mPresenter);
        verify(mInteractor).queryCities();
    }

    @Test
    public void testOnCitySelected()
    {
        City city = new City(123, "Testowe");

        mPresenter.onCitySelected(city);

        verify(mRouter).backToActualWeather(city);
    }

    @Test
    public void testOnSearchIconClicked()
    {
        mPresenter.onSearchIconClicked();

        verify(mView).showSearcher();
    }

    @Test
    public void testOnSearchQueryChanged()
    {
        List<City> cities = new ArrayList<>();
        cities.add(new City(1, "Augustów"));
        cities.add(new City(2, "Chojnice"));
        cities.add(new City(3, "Chojna"));
        cities.add(new City(4, "Warszawa"));
        cities.add(new City(5, "Abchojna"));

        ArgumentCaptor<List<City>> captor = ArgumentCaptor.forClass(List.class);
        mPresenter.onCities(cities);
        mPresenter.onSearchQueryChanged("Choj");

        verify(mView, times(2)).showCities(captor.capture());
        List<City> capturedCities = captor.getValue();

        assertEquals(3, capturedCities.size());

        assertEquals(2, capturedCities.get(0).getId());
        assertEquals(3, capturedCities.get(1).getId());
        assertEquals(5, capturedCities.get(2).getId());
    }

    @Test
    public void testOnCities()
    {
        List<City> cities = new ArrayList<>();
        cities.add(new City(1, "Augustów"));
        cities.add(new City(2, "Chojnice"));
        cities.add(new City(3, "Chojna"));
        cities.add(new City(4, "Warszawa"));
        cities.add(new City(5, "Abchojna"));

        mPresenter.onCities(cities);

        verify(mView).showCities(cities);
    }

    @Test
    public void testOnError()
    {
        mPresenter.onError();

        verify(mView).showError();
    }
}