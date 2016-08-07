package com.github.jaccek.weatherapp.frameworks.view;

import android.support.v7.app.AppCompatActivity;

import com.github.jaccek.weatherapp.frameworks.ApplicationWeather;

/**
 * Created by jacek on 8/6/16.
 */
public class ActivityBase extends AppCompatActivity
{
    public ApplicationWeather getApplicationObject()
    {
        return (ApplicationWeather) getApplication();
    }
}
