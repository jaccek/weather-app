package com.github.jaccek.weatherapp.actualweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.jaccek.weatherapp.ApplicationWeather;
import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Responsibility: routing actions from actual weather module to Android system.
 */
public class ActivityActualWeather extends AppCompatActivity implements
        ContractActualWeather.View
{
    private final int LAYOUT_ID = R.layout.activity_actual_weather;

    ContractActualWeather.Presenter mPresenter;

    private TextView mDateView;
    private TextView mCityNameView;
    private TextView mTemperatureView;
    private TextView mSunriseHourView;
    private TextView mSunsetHourView;
    private TextView mWeatherTypeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);

        mDateView = (TextView) findViewById(R.id.activity_weather_date);
        mCityNameView = (TextView) findViewById(R.id.activity_weather_city);
        mTemperatureView = (TextView) findViewById(R.id.activity_weather_temperature);
        mSunriseHourView = (TextView) findViewById(R.id.activity_weather_sunrise_hour);
        mSunsetHourView = (TextView) findViewById(R.id.activity_weather_sunset_hour);
        mWeatherTypeView = (TextView) findViewById(R.id.activity_weather_type);

        mPresenter = ((ApplicationWeather) getApplication()).getComponent().getActualWeatherPresenter();
        mPresenter.init(this, null);
        mPresenter.onCreate();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String date = sdf.format(new Date());
        mDateView.setText(date);
    }

    @Override
    public void showCity(City pCity)
    {
        mCityNameView.setText(pCity.getName());
    }

    @Override
    public void showWeather(ActualWeatherData pWeatherData)
    {
        mTemperatureView.setText("" + pWeatherData.getTemperature());
        mSunriseHourView.setText(pWeatherData.getSunriseHour().toString());
        mSunsetHourView.setText(pWeatherData.getSunsetHour().toString());

        // TODO: getSymbolNight
        mWeatherTypeView.setText(pWeatherData.getWeatherType().getSymbolDay());
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
