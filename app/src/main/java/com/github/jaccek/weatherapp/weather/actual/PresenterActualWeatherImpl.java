package com.github.jaccek.weatherapp.weather.actual;

/**
 * Presenter for actual weather.
 */
public class PresenterActualWeatherImpl implements PresenterActualWeather
{
    private ViewActualWeather mViewActualWeather;

    public PresenterActualWeatherImpl(ViewActualWeather pViewActualWeather)
    {
        mViewActualWeather = pViewActualWeather;
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
