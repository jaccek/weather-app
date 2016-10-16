package com.github.jaccek.weatherapp;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.github.jaccek.weatherapp.dagger.ModuleActualWeather;
import com.github.jaccek.weatherapp.dagger.ApplicationComponent;
import com.github.jaccek.weatherapp.dagger.DaggerApplicationComponent;

/**
 * Created by jacek on 8/20/16.
 */
public class ApplicationWeather extends Application
{
    private ApplicationComponent mComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .moduleActualWeather(new ModuleActualWeather())
                .build();
    }

    public ApplicationComponent getComponent()
    {
        return mComponent;
    }

    @VisibleForTesting
    protected void setComponent(ApplicationComponent pComponent)
    {
        mComponent = pComponent;
    }
}
