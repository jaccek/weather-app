package com.github.jaccek.weatherapp.actualweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.github.jaccek.weatherapp.ApplicationWeather;
import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.choosecity.view.ActivityChooseCity;
import com.github.jaccek.weatherapp.data.ActualWeatherData;
import com.github.jaccek.weatherapp.data.City;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Responsibility: routing actions from actual weather module to Android system.
 */
public class ActivityActualWeather extends AppCompatActivity implements
        ContractActualWeather.View,
        ContractActualWeather.Router
{
    private static final int CODE_CHOOSE_CITY = 1;
    private static final int LAYOUT_ID = R.layout.activity_actual_weather;

    ContractActualWeather.Presenter mPresenter;
    ContractActualWeather.PresenterForRouter mPresenterForRouter;

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
        mPresenter.init(this, this);
        mPresenter.onCreate();

        mCityNameView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View pView)
            {
                mPresenter.onCityClicked();
            }
        });

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
        // TODO:
    }

    @Override
    public void showConnectionError()
    {
        // TODO:
    }

    @Override
    public void startNextDaysActivity()
    {
        // TODO:
    }

    @Override
    public void startChangeCityActivity(ContractActualWeather.PresenterForRouter pPresenter, City pSelectedCity)
    {
        mPresenterForRouter = pPresenter;
        ActivityChooseCity.startActivityForResult(this, pSelectedCity, CODE_CHOOSE_CITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // TODO: https://google.github.io/android-testing-support-library/docs/espresso/intents/
        super.onActivityResult(requestCode, resultCode, data);
    }
}
