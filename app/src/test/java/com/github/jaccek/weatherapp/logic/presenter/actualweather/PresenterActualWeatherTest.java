package com.github.jaccek.weatherapp.logic.presenter.actualweather;

import com.github.jaccek.weatherapp.core.entities.Hour;
import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.frameworks.database.DataHandler;
import com.github.jaccek.weatherapp.logic.database.IManagerData;
import com.github.jaccek.weatherapp.logic.view.actualweather.IViewActualWeather;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Tests for {@link IPresenterActualWeather}.
 */
public class PresenterActualWeatherTest
{
    @Mock
    IViewActualWeather mViewActualWeatherMock;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Test
    public void testOnCreate() throws Exception
    {
        IManagerData managerData = Mockito.mock(IManagerData.class);
        PresenterActualWeather presenter = new PresenterActualWeather(mViewActualWeatherMock, managerData);

        presenter.onCreate();
        verify(managerData).getActualWeather(any(DataHandler.class));
    }

    @Test
    public void testOnData() throws Exception
    {
        PresenterActualWeather presenter = new PresenterActualWeather(mViewActualWeatherMock, null);

        WeatherDataActual actualWeather = new WeatherDataActual();
        actualWeather.setTemperature(18);
        actualWeather.setWindSpeed(1.54f);
        actualWeather.setSunriseHour(new Hour(5, 24));
        actualWeather.setSunsetHour(new Hour(21, 32));

        presenter.onData(actualWeather);
        verify(mViewActualWeatherMock).showWeather(actualWeather);
    }

    @Test
    public void testOnError() throws Exception
    {
        PresenterActualWeather presenter = new PresenterActualWeather(mViewActualWeatherMock, null);

        presenter.onError();
        verify(mViewActualWeatherMock).showConnectionError();
    }

    @Test
    public void testOnNextWeekButtonClicked() throws Exception
    {
        PresenterActualWeather presenter = new PresenterActualWeather(mViewActualWeatherMock, null);
        presenter.onNextWeekButtonClicked();

        verify(mViewActualWeatherMock).startActivityNextWeek();
    }

    @Test
    public void testOnCityNameClicked() throws Exception
    {
        PresenterActualWeather presenter = new PresenterActualWeather(mViewActualWeatherMock, null);
        presenter.onCityNameClicked();

        verify(mViewActualWeatherMock).startActivityChooseCity();
    }
}