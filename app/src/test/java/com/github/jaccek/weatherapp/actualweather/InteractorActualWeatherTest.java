package com.github.jaccek.weatherapp.actualweather;

import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.actualweather.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.actualweather.interactor.InteractorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawCity;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.ThreadRunnerStrategy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Matchers.anyInt;
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
    ConnectorActualWeather mConnector;
    @Mock
    ConverterCity mConverter;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mThreadRunner = new ThreadRunnerMocked();
        mInteractor = new InteractorActualWeather(mThreadRunner, mConnector, mConverter);
    }

    @Test
    public void testRequestUserCitySuccess() throws Exception
    {
        City city = new City();
        RawCity rawCity = new RawCity();
        when(mConnector.downloadCity(anyInt())).thenReturn(rawCity);
        when(mConverter.convert(rawCity)).thenReturn(city);

        mInteractor.requestUserCity(mPresenter);

        verify(mConnector).downloadCity(anyInt());  // TODO: change anyInt() to concrete city id
        verify(mConverter).convert(rawCity);
        verify(mPresenter).onCity(city);
    }

    @Test
    public void testRequestUserCityFailDownloading() throws Exception
    {
        when(mConnector.downloadCity(anyInt())).thenThrow(ExceptionNetwork.class);

        mInteractor.requestUserCity(mPresenter);

        verify(mConnector).downloadCity(anyInt());  // TODO: change anyInt() to concrete city id
        verify(mPresenter).onConnectionError();
    }

    @Test
    public void testRequestUserCityFailConversion() throws Exception
    {
        RawCity rawCity = new RawCity();
        when(mConnector.downloadCity(anyInt())).thenReturn(rawCity);
        when(mConverter.convert(rawCity)).thenThrow(ExceptionConversion.class);

        mInteractor.requestUserCity(mPresenter);

        verify(mConnector).downloadCity(anyInt());  // TODO: change anyInt() to concrete city id
        verify(mConverter).convert(rawCity);
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