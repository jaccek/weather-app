package com.github.jaccek.weatherapp.frameworks.database;

import android.support.annotation.Nullable;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherData;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherDay;
import com.github.jaccek.weatherapp.frameworks.network.data.wpweather.WpWeatherForecast;
import com.github.jaccek.weatherapp.frameworks.network.provider.IWeatherDataProvider;
import com.github.jaccek.weatherapp.logic.database.IManagerData;

import java.util.Calendar;

/**
 * ManagerData is used to store data in a phone memory.
 */
public class ManagerData implements IManagerData
{
    IWeatherDataProvider mDataProvider;

    public ManagerData(IWeatherDataProvider pWeatherDataProvider)
    {
        mDataProvider = pWeatherDataProvider;
    }

    @Override
    @Nullable
    public void getActualWeather(final Calendar pActualDate, final DataHandler<WeatherDataActual> pDataHandler)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                getActualWeatherInBackground(pActualDate, pDataHandler);
            }
        }).start();
    }

    void getActualWeatherInBackground(Calendar pActualDate, DataHandler<WeatherDataActual> pDataHandler)
    {
        try
        {
            WpWeatherForecast forecast = mDataProvider.getWeatherForecast();
            WpWeatherDay weatherDay = forecast.getWeatherDay(pActualDate);
            WpWeatherData weatherData = weatherDay.getWeatherData(pActualDate);

            WeatherDataActual actualData = new WeatherDataActual();
            actualData.setSunriseHour(weatherDay.getSunriseHour());
            actualData.setSunsetHour(weatherDay.getSunsetHour());
            actualData.setTemperature(weatherData.getTemperature());
            actualData.setWeatherType(weatherData.getWeatherType().convertWeatherType());

            pDataHandler.onData(actualData);
        }
        catch(Exception pE)
        {
            pE.printStackTrace();
            pDataHandler.onError();
        }
    }
}
