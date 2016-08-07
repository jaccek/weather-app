package com.github.jaccek.weatherapp.frameworks;

import android.app.Application;

import com.github.jaccek.weatherapp.frameworks.database.ManagerData;
import com.github.jaccek.weatherapp.frameworks.network.provider.IWeatherDataProvider;
import com.github.jaccek.weatherapp.frameworks.network.provider.wpweather.WpWeatherProvider;
import com.github.jaccek.weatherapp.logic.database.IManagerData;
import com.github.jaccek.weatherapp.logic.presenter.PresenterBase;
import com.github.jaccek.weatherapp.logic.presenter.PresenterNotFoundException;
import com.github.jaccek.weatherapp.logic.presenter.actualweather.PresenterActualWeather;
import com.github.jaccek.weatherapp.logic.view.actualweather.IViewActualWeather;

/**
 * {@link Application} class.
 */
public class ApplicationWeatherImpl extends Application implements ApplicationWeather
{
    private static IManagerData sManagerData;
    private static IWeatherDataProvider sDataProvider;

    @Override
    public void onCreate()
    {
        super.onCreate();
        initManagerData();
    }

    private void initManagerData()
    {
        initDataProvider();
        sManagerData = new ManagerData(sDataProvider);
    }

    private void initDataProvider()
    {
        sDataProvider = new WpWeatherProvider();
    }

    @Override
    public <T extends PresenterBase> T getPresenter(Class<?> pViewClass) throws PresenterNotFoundException
    {
        if (IViewActualWeather.class.isAssignableFrom(pViewClass))
        {
            return (T) new PresenterActualWeather(sManagerData);
        }

        throw new PresenterNotFoundException("There is no presenter for view " + pViewClass.getSimpleName());
    }
}
