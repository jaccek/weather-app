package com.github.jaccek.weatherapp;

import android.app.Application;

import com.github.jaccek.weatherapp.database.ManagerData;

/**
 * {@link Application} class.
 */
public class ApplicationWeather extends Application
{
    public static ManagerData sManagerData;

    public static ManagerData getManagerData()
    {
        return sManagerData;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();

        //Context context = getApplicationContext();
        sManagerData = new ManagerData();
    }
}
