package com.github.jaccek.weatherapp.frameworks.database;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;
import com.github.jaccek.weatherapp.frameworks.network.provider.IWeatherDataProvider;
import com.github.jaccek.weatherapp.helpers.ForecastLoader;
import com.github.jaccek.weatherapp.helpers.InvalidCallbackException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Created by jacek on 7/31/16.
 */
public class ManagerDataTest
{
    private ManagerData mManagerData;
    private IWeatherDataProvider mDataProvider;

    @Before
    public void init()
    {
        mDataProvider = Mockito.mock(IWeatherDataProvider.class);
        mManagerData = new ManagerData(mDataProvider);
    }

    @Test
    public void getActualWeatherTestCorrectData() throws Exception
    {
        WpWeatherForecast wpWeatherForecast = ForecastLoader.getWpWeatherForecast();
        when(mDataProvider.getWeatherForecast()).thenReturn(wpWeatherForecast);

        mManagerData.getActualWeather(new DataHandler<WeatherDataActual>()
        {
            @Override
            public void onData(WeatherDataActual pData)
            {
                // TODO: check if actual weather is equal to wpWeatherForecast
            }

            @Override
            public void onError()
            {
                throw new InvalidCallbackException();
            }
        });
    }
}