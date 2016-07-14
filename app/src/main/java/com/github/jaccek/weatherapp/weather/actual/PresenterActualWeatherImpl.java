package com.github.jaccek.weatherapp.weather.actual;

import com.github.jaccek.weatherapp.database.IManagerData;
import com.github.jaccek.weatherapp.network.data.IWeatherData;

import java.util.Calendar;

/**
 * Presenter for actual weather.
 */
public class PresenterActualWeatherImpl implements PresenterActualWeather
{
    private ViewActualWeather mViewActualWeather;
    private IManagerData mManagerData;

    public PresenterActualWeatherImpl(ViewActualWeather pViewActualWeather, IManagerData pManagerData)
    {
        mManagerData = pManagerData;
        mViewActualWeather = pViewActualWeather;
    }

    @Override
    public void onCreate()
    {
        IWeatherData data = mManagerData.getWeather(Calendar.getInstance());
        mViewActualWeather.showWeather(data);
    }

    @Override
    public void onNextWeekButtonClicked()
    {
        mViewActualWeather.startActivityNextWeek();
    }

    @Override
    public void onCityNameClicked()
    {
        mViewActualWeather.startActivityChooseCity();
    }
}
