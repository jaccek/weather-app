package com.github.jaccek.weatherapp.logic.presenter.actualweather;

import com.github.jaccek.weatherapp.logic.database.IManagerData;
import com.github.jaccek.weatherapp.frameworks.network.data.IWeatherData;
import com.github.jaccek.weatherapp.logic.view.actualweather.ViewActualWeather;

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
