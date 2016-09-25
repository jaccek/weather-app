package com.github.jaccek.weatherapp.actualweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;

/**
 * Responsibility: routing actions from actual weather module to Android system.
 */
public class ActivityActualWeather extends AppCompatActivity implements
        ContractActualWeather.View
{
    private final int LAYOUT_ID = R.layout.activity_actual_weather;

    private TextView mCityNameView;
    private TextView mTemperatureView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);

        mCityNameView = (TextView) findViewById(R.id.activity_weather_city);
        mTemperatureView = (TextView) findViewById(R.id.activity_weather_temperature);
    }

    @Override
    public void showCity(City pCity)
    {
        mCityNameView.setText(pCity.getName());
    }

    @Override
    public void showWeather(ActualWeatherData pWeatherData)
    {
        mTemperatureView.setText(pWeatherData.getTemperature());
    }

    @Override
    public void showLoader()
    {

    }

    @Override
    public void showConnectionError()
    {

    }
}
