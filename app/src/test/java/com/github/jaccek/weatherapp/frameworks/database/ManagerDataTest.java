package com.github.jaccek.weatherapp.frameworks.database;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherData;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherDay;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;
import com.github.jaccek.weatherapp.frameworks.network.provider.IWeatherDataProvider;
import com.github.jaccek.weatherapp.helpers.ForecastLoader;
import com.github.jaccek.weatherapp.helpers.InvalidCallbackException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.Invocation;

import java.lang.reflect.Method;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by jacek on 7/31/16.
 */
public class ManagerDataTest
{
    private ManagerData mManagerData;
    private IWeatherDataProvider mDataProvider;
    private WpWeatherForecast mWeatherForecast;
    private Calendar mForecastDay;

    @Before
    public void init()
    {
        mDataProvider = Mockito.mock(IWeatherDataProvider.class);
        mManagerData = new ManagerData(mDataProvider);

        mWeatherForecast = ForecastLoader.getWpWeatherForecast();
        mForecastDay = ForecastLoader.getDateOfWpWeatherForecast();
    }

    @Test
    public void getWeatherTestCorrectData() throws Exception
    {
        when(mDataProvider.getWeatherForecast()).thenReturn(mWeatherForecast);

        mManagerData.getActualWeatherInBackground(mForecastDay, new DataHandler<WeatherDataActual>()
        {
            @Override
            public void onData(WeatherDataActual pData)
            {
                WpWeatherDay weatherDay = mWeatherForecast.getWeatherDay(mForecastDay);
                WpWeatherData weatherData = weatherDay.getWeatherData(mForecastDay);
                assertEquals(weatherData.getWeatherType().convertWeatherType(), pData.getWeatherType());
                assertEquals(weatherDay.getSunriseHour(), pData.getSunriseHour());
                assertEquals(weatherDay.getSunsetHour(), pData.getSunsetHour());
                assertEquals(weatherData.getTemperature(), pData.getTemperature(), 0.001f);
            }

            @Override
            public void onError()
            {
                throw new InvalidCallbackException();
            }
        });
    }

    @Test
    public void getWeatherTestCallingCallbacks() throws Exception
    {
        DataHandler<WeatherDataActual> handlerMock = Mockito.mock(DataHandler.class);
        when(mDataProvider.getWeatherForecast()).thenReturn(mWeatherForecast);

        mManagerData.getActualWeather(mForecastDay, handlerMock);

        Thread.sleep(100);
        Method onDataMethod = DataHandler.class.getMethod("onData", Object.class);
        Method onErrorMethod = DataHandler.class.getMethod("onError");
        int invocationCounter = 0;
        for (Invocation invocation : Mockito.mockingDetails(handlerMock).getInvocations())
        {
            if (onDataMethod.equals(invocation.getMethod()))
            {
                invocationCounter++;
            }
            if (onErrorMethod.equals(invocation.getMethod()))
            {
                invocationCounter++;
            }
        }
        assertEquals("One of callback functions should be called", 1, invocationCounter);
    }
}