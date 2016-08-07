package com.github.jaccek.weatherapp.frameworks.view.actualweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.core.entities.City;
import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.core.utils.UnitConverter;
import com.github.jaccek.weatherapp.frameworks.utils.WeatherTypeConverter;
import com.github.jaccek.weatherapp.frameworks.view.ActivityBase;
import com.github.jaccek.weatherapp.frameworks.view.choosecity.ActivityCityChooser;
import com.github.jaccek.weatherapp.logic.presenter.actualweather.PresenterActualWeather;
import com.github.jaccek.weatherapp.logic.view.actualweather.IViewActualWeather;

import java.util.Locale;

/**
 * Activity showing weather data.
 */
public class ActivityActualWeather extends ActivityBase implements IViewActualWeather
{
    private final static int LAYOUT_ID = R.layout.activity_actual_weather;

    private ImageView mBackgroundImageView;
    private TextView mTemperatureView;
    private TextView mWeatherTypeView;
    private TextView mSunriseHourView;
    private TextView mSunsetHourView;
    private TextView mWindSpeedView;
    private TextView mCityNameView;
    private TextView mDateView;

    PresenterActualWeather mPresenterActualWeather;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);

        mBackgroundImageView = (ImageView) findViewById(R.id.activity_weather_background);
        mTemperatureView = (TextView) findViewById(R.id.activity_weather_temperature);
        mWeatherTypeView = (TextView) findViewById(R.id.activity_weather_type);
        mSunriseHourView = (TextView) findViewById(R.id.activity_weather_sunrise_hour);
        mSunsetHourView = (TextView) findViewById(R.id.activity_weather_sunset_hour);
        mWindSpeedView = (TextView) findViewById(R.id.activity_weather_wind_speed);
        mCityNameView = (TextView) findViewById(R.id.activity_weather_city);
        mDateView = (TextView) findViewById(R.id.activity_weather_date);

        mCityNameView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View pView)
            {
                mPresenterActualWeather.onCityNameClicked();
            }
        });

        mPresenterActualWeather = getApplicationObject().getPresenter(this.getClass());
        mPresenterActualWeather.setViewActualWeather(this);
        mPresenterActualWeather.onCreate();
    }

    @Override
    public void showWeather(WeatherDataActual pWeatherData)
    {
        String temperature = String.format(Locale.getDefault(), "%d", Math.round(pWeatherData.getTemperature()));
        mTemperatureView.setText(temperature);

        mSunriseHourView.setText(pWeatherData.getSunriseHour().toString());
        mSunsetHourView.setText(pWeatherData.getSunsetHour().toString());

        String wind = String.format(Locale.getDefault(), "%.1f", pWeatherData.getWindSpeed());
        mWindSpeedView.setText(wind);

        mWeatherTypeView.setText(WeatherTypeConverter.toString(pWeatherData.getWeatherType()));

        mDateView.setText(UnitConverter.timestampToDate(System.currentTimeMillis()));
    }

    @Override
    public void startActivityNextWeek()
    {
        // TODO: implement
    }

    @Override
    public void startActivityChooseCity()
    {
        ActivityCityChooser.startActivity(this);
    }

    @Override
    public void showConnectionError()
    {
        // TODO: implement
    }

    @Override
    public void setCity(City pCity)
    {
        mCityNameView.setText(pCity.getName());
    }
}
