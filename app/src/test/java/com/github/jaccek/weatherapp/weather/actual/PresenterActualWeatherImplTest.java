package com.github.jaccek.weatherapp.weather.actual;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

/**
 * Tests for {@link PresenterActualWeather}.
 */
public class PresenterActualWeatherImplTest
{
    @Mock
    ViewActualWeather mViewActualWeatherMock;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Test
    public void testOnNextWeekButtonClicked() throws Exception
    {
        PresenterActualWeatherImpl presenter = new PresenterActualWeatherImpl(mViewActualWeatherMock);
        presenter.onNextWeekButtonClicked();

        verify(mViewActualWeatherMock).startActivityNextWeek();
    }

    @Test
    public void testOnCityNameClicked() throws Exception
    {
        PresenterActualWeatherImpl presenter = new PresenterActualWeatherImpl(mViewActualWeatherMock);
        presenter.onCityNameClicked();

        verify(mViewActualWeatherMock).startActivityChooseCity();
    }
}