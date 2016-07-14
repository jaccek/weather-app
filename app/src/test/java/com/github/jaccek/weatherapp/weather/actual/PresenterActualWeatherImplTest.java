package com.github.jaccek.weatherapp.weather.actual;

import com.github.jaccek.weatherapp.database.IManagerData;
import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherData;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Calendar;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        PresenterActualWeatherImpl presenter = new PresenterActualWeatherImpl(mViewActualWeatherMock, null);
        presenter.onNextWeekButtonClicked();

        verify(mViewActualWeatherMock).startActivityNextWeek();
    }

    @Test
    public void testOnCityNameClicked() throws Exception
    {
        PresenterActualWeatherImpl presenter = new PresenterActualWeatherImpl(mViewActualWeatherMock, null);
        presenter.onCityNameClicked();

        verify(mViewActualWeatherMock).startActivityChooseCity();
    }

    @Test
    public void testOnCreateNullWeatherData() throws Exception
    {
        IManagerData managerData = Mockito.mock(IManagerData.class);

        WpWeatherData data = new WpWeatherData();
        data.setWeatherType(IWeatherData.WeatherType.SUNNY);
        data.setWindSpeed(12);
        data.setTemperature(28);
        when(managerData.getWeather(any(Calendar.class))).thenReturn(data);

        PresenterActualWeatherImpl presenter = new PresenterActualWeatherImpl(mViewActualWeatherMock, managerData);
        presenter.onCreate();

        verify(mViewActualWeatherMock).showWeather(data);
    }
}