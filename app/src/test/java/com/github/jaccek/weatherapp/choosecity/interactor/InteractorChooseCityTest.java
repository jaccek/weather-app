package com.github.jaccek.weatherapp.choosecity.interactor;

import com.github.jaccek.weatherapp.choosecity.ContractChooseCity;
import com.github.jaccek.weatherapp.choosecity.interactor.DataCollectorChooseCity;
import com.github.jaccek.weatherapp.choosecity.interactor.InteractorChooseCity;
import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.testutils.ThreadRunnerSingleThread;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jacek on 10/8/16.
 */
public class InteractorChooseCityTest
{
    private InteractorChooseCity mInteractor;
    @Mock
    private ContractChooseCity.PresenterForInteractor mPresenter;
    @Mock
    private DataCollectorChooseCity mDataCollector;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        ThreadRunnerStrategy threadRunner = new ThreadRunnerSingleThread();
        mInteractor = new InteractorChooseCity(threadRunner, mDataCollector);
        mInteractor.setPresenter(mPresenter);
    }

    @Test
    public void testQueryCities_success() throws Exception
    {
        List<City> cities = new ArrayList<>();
        cities.add(new City(1, "Warszawa"));
        cities.add(new City(2, "Gdańsk"));
        when(mDataCollector.getCities()).thenReturn(cities);

        mInteractor.queryCities();

        verify(mDataCollector).getCities();
        verify(mPresenter).onCities(cities);
    }

    @Test
    public void testQueryCities_networkException() throws Exception
    {
        when(mDataCollector.getCities()).thenThrow(ExceptionNetwork.class);

        mInteractor.queryCities();

        verify(mDataCollector).getCities();
        verify(mPresenter).onError();
    }
}