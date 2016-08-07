package com.github.jaccek.weatherapp.frameworks;

import com.github.jaccek.weatherapp.logic.presenter.PresenterBase;
import com.github.jaccek.weatherapp.logic.presenter.PresenterNotFoundException;

/**
 * Created by jacek on 8/6/16.
 */
public interface ApplicationWeather
{
    <T extends PresenterBase> T getPresenter(Class<?> pViewClass) throws PresenterNotFoundException;
}
