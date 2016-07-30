package com.github.jaccek.weatherapp;

import android.app.Application;
import android.content.Context;

import com.github.jaccek.weatherapp.frameworks.dagger.ComponentApplication;
import com.github.jaccek.weatherapp.frameworks.dagger.DaggerComponentApplication;

/**
 * {@link Application} class.
 */
public class ApplicationWeather extends Application
{
    private ComponentApplication mComponentApplication;

    public static ComponentApplication getComponentApplication(Context pContext)
    {
        ApplicationWeather app = (ApplicationWeather) pContext.getApplicationContext();
        if (app.mComponentApplication == null)
        {
            app.mComponentApplication = DaggerComponentApplication.builder()
                    .build();
        }

        return app.mComponentApplication;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
    }
}
