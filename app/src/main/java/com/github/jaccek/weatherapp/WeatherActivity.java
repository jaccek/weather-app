package com.github.jaccek.weatherapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity showing weather data.
 */
public class WeatherActivity extends AppCompatActivity
{
    private final static int LAYOUT_ID = R.layout.activity_weather;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);
    }
}
