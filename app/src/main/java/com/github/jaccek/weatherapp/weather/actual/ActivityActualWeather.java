package com.github.jaccek.weatherapp.weather.actual;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.github.jaccek.weatherapp.utils.UnitConverter;

import java.util.Locale;

/**
 * Activity showing weather data.
 */
public class ActivityActualWeather extends AppCompatActivity
{
    private final static int LAYOUT_ID = R.layout.activity_actual_weather;

    private ImageView mBackgroundImageView;
    private TextView mTemperatureView;
    private TextView mSunriseHourView;
    private TextView mSunsetHourView;
    private TextView mWindSpeedView;
    private TextView mCityNameView;
    private TextView mDateView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);

        mBackgroundImageView = (ImageView) findViewById(R.id.activity_weather_background);
        mTemperatureView = (TextView) findViewById(R.id.activity_weather_temperature);
        mSunriseHourView = (TextView) findViewById(R.id.activity_weather_sunrise_hour);
        mSunsetHourView = (TextView) findViewById(R.id.activity_weather_sunset_hour);
        mWindSpeedView = (TextView) findViewById(R.id.activity_weather_wind_speed);
        mCityNameView = (TextView) findViewById(R.id.activity_weather_city);
        mDateView = (TextView) findViewById(R.id.activity_weather_date);

//        IWeatherDataProvider provider = new YahooWeatherProvider();
//        IWeatherData data;
//        try
//        {
//            data = provider.getWeatherData();
//            setWeatherData(data);
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
    }

    private void setWeatherData(IWeatherData pWeatherData)
    {
        String temperature = String.format(Locale.getDefault(), "%d", Math.round(pWeatherData.getTemperature()));
        mTemperatureView.setText(temperature);

        mSunriseHourView.setText(UnitConverter.timestampToHour(pWeatherData.getSunriseTimestamp()));
        mSunsetHourView.setText(UnitConverter.timestampToHour(pWeatherData.getSunsetTimestamp()));

        String wind = String.format(Locale.getDefault(), "%.1f", pWeatherData.getWindSpeed());
        mWindSpeedView.setText(wind);

        // TODO: city!
        mCityNameView.setText("TEST");

        mDateView.setText(UnitConverter.timestampToDate(System.currentTimeMillis()));
    }
}
