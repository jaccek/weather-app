package com.github.jaccek.weatherapp.logic.presenter.actualweather;

import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.frameworks.database.DataHandler;
import com.github.jaccek.weatherapp.logic.database.IManagerData;
import com.github.jaccek.weatherapp.logic.view.actualweather.IViewActualWeather;

/**
 * Presenter for actual weather.
 */
public class PresenterActualWeather implements IPresenterActualWeather, DataHandler<WeatherDataActual>
{
    private IViewActualWeather mViewActualWeather;
    private IManagerData mManagerData;

    public PresenterActualWeather(IManagerData pManagerData)
    {
        mManagerData = pManagerData;
    }

    public void setViewActualWeather(IViewActualWeather pViewActualWeather)
    {
        mViewActualWeather = pViewActualWeather;
    }

    @Override
    public void onCreate()
    {
        mManagerData.getActualWeather(this);
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

    @Override
    public void onData(WeatherDataActual pData)
    {
        mViewActualWeather.showWeather(pData);
    }

    @Override
    public void onError()
    {
        mViewActualWeather.showConnectionError();
    }
}
