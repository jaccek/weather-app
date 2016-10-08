package com.github.jaccek.weatherapp.choosecity;

import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.network.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.testutils.ThreadRunnerSingleThread;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;

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
        ConverterCity converterCity = new ConverterCity();
        mInteractor = new InteractorChooseCity(threadRunner, mDataCollector, converterCity);
        mInteractor.setPresenter(mPresenter);
    }

    @Test
    public void testQueryCities()
    {
        List<RawCity> rawCities = new ArrayList<>();
        rawCities.add(new RawCity(1, "Warszawa"));
        rawCities.add(new RawCity(2, "Gdańsk"));
        when(mDataCollector.getCities()).thenReturn(rawCities);

        mInteractor.queryCities();

        verify(mDataCollector).getCities();
        ArgumentCaptor<List<City>> captor = ArgumentCaptor.forClass(List.class);
        verify(mPresenter).onCities(captor.capture());

        List<City> capturedCities = captor.getValue();
        assertEquals(rawCities.size(), capturedCities.size());
        for (int i = 0; i < rawCities.size(); ++i)
        {
            assertEquals(rawCities.get(i).getId(), capturedCities.get(i).getId());
            assertEquals(rawCities.get(i).getName(), capturedCities.get(i).getName());
        }
    }
}