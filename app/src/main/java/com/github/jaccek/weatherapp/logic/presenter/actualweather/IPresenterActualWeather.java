package com.github.jaccek.weatherapp.logic.presenter.actualweather;

import com.github.jaccek.weatherapp.logic.presenter.PresenterBase;

/**
 * Presenter for actual weather activity.
 */
public interface IPresenterActualWeather extends PresenterBase
{
    void onCreate();

    void onNextWeekButtonClicked();

    void onCityNameClicked();
}
