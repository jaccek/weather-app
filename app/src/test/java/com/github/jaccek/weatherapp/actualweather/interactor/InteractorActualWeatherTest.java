package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.actualweather.ContractActualWeather;
import com.github.jaccek.weatherapp.data.ActualWeatherData;
import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
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
        mThreadRunner = new ThreadRunnerMocked();
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

    /**
     * Mock of {@link ThreadRunnerMocked}. It runs all {@link Runnable}s in actual thread.
     */
    private static class ThreadRunnerMocked implements ThreadRunnerStrategy
    {
        @Override
        public void executeInBackground(Runnable pRunnable)
        {
            pRunnable.run();
        }

        @Override
        public void executeInMainThread(Runnable pRunnable)
        {
            pRunnable.run();
        }
    }
}