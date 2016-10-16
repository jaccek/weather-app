package com.github.jaccek.weatherapp.interactors;

import com.github.jaccek.weatherapp.contracts.ContractActualWeather;
import com.github.jaccek.weatherapp.interactors.InteractorActualWeather;
import com.github.jaccek.weatherapp.models.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.managers.DataCollectorActualWeather;
import com.github.jaccek.weatherapp.models.ActualWeatherData;
import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.testutils.ThreadRunnerSingleThread;
import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jacek on 8/20/16.
 */
public class InteractorActualWeatherTest
{
    InteractorActualWeather mInteractor;
    ThreadRunnerStrategy mThreadRunner;
    @Mock
    ContractActualWeather.PresenterForInteractor mPresenter;
    @Mock
    DataCollectorActualWeather mDataCollector;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mThreadRunner = new ThreadRunnerSingleThread();
        mInteractor = new InteractorActualWeather(mThreadRunner, mDataCollector);

        // prevent printing exception log running line:
        // when(mDataCollector.getUserCity()).thenThrow(ExceptionNetwork.class);
        System.setErr(new PrintStream(new OutputStream()
        {
            @Override
            public void write(int i)
            {
            }
        }));
    }

    @Test
    public void testRequestUserCitySuccess() throws Exception
    {
        City city = new City();
        when(mDataCollector.getUserCity()).thenReturn(city);

        mInteractor.requestUserCity(mPresenter);

        verify(mDataCollector).getUserCity();
        verify(mPresenter).onCity(city);
    }

    @Test
    public void testRequestUserCityFailDownloading() throws Exception
    {
        when(mDataCollector.getUserCity()).thenThrow(ExceptionNetwork.class);

        mInteractor.requestUserCity(mPresenter);

        verify(mDataCollector).getUserCity();
        verify(mPresenter).onConnectionError();
    }

    @Test
    public void testRequestUserCityFailConversion() throws Exception
    {
        when(mDataCollector.getUserCity()).thenThrow(ExceptionConversion.class);

        mInteractor.requestUserCity(mPresenter);

        verify(mDataCollector).getUserCity();
        verify(mPresenter).onConnectionError();
    }

    @Test
    public void testRequestActualWeatherDataSuccess() throws Exception
    {
        City city = new City();
        ActualWeatherData weatherData = new ActualWeatherData();
        when(mDataCollector.getActualWeatherData(city)).thenReturn(weatherData);

        mInteractor.requestActualWeatherData(mPresenter, city);

        verify(mDataCollector).getActualWeatherData(city);
        verify(mPresenter).onActualWeatherData(weatherData);
    }

    @Test
    public void testRequestActualWeatherDataFailDownloading() throws Exception
    {
        City city = new City();
        when(mDataCollector.getActualWeatherData(city)).thenThrow(ExceptionNetwork.class);

        mInteractor.requestActualWeatherData(mPresenter, city);

        verify(mDataCollector).getActualWeatherData(city);
        verify(mPresenter).onConnectionError();
    }

    @Test
    public void testRequestActualWeatherDataFailConversion() throws Exception
    {
        City city = new City();
        when(mDataCollector.getActualWeatherData(city)).thenThrow(ExceptionConversion.class);

        mInteractor.requestActualWeatherData(mPresenter, city);

        verify(mDataCollector).getActualWeatherData(city);
        verify(mPresenter).onConnectionError();
    }


}