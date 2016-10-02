package com.github.jaccek.weatherapp.actualweather;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.actualweather.data.Hour;
import com.github.jaccek.weatherapp.actualweather.data.WeatherType;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.verify;

/**
 * Created by jacek on 9/25/16.
 */
@RunWith(AndroidJUnit4.class)
public class ActivityActualWeatherTest
{
    ActivityActualWeather mActivity;
    ContractActualWeather.Presenter mPresenter;

    @Rule
    public ActivityTestRule<ActivityActualWeather> mActivityRule = new ActivityTestRule<>(ActivityActualWeather.class);

    @Before
    public void init()
    {
        mActivity = mActivityRule.getActivity();
        mPresenter = mActivity.mPresenter;
    }

    @Test
    public void testOnCreate()
    {
        // when section is unnecessary - onCreate already invoked
        verify(mPresenter).init(mActivity, null);
        verify(mPresenter).onCreate();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String todayDate = sdf.format(new Date());
        onView(withId(R.id.activity_weather_date)).check(matches(withText(todayDate)));
    }

    @Test
    public void testShowCity()
    {
        final String cityName = "Warszawa";
        final City city = new City();
        city.setName(cityName);

        mActivity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                mActivity.showCity(city);
            }
        });

        onView(withId(R.id.activity_weather_city)).check(matches(withText(cityName)));
    }

    @Test
    public void testShowWeather()
    {
        final ActualWeatherData weatherData = new ActualWeatherData();
        weatherData.setTemperature(18);
        weatherData.setSunriseHour(new Hour(8, 45));
        weatherData.setSunsetHour(new Hour(18, 17));
        weatherData.setWeatherType(WeatherType.HAIL);

        mActivity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                mActivity.showWeather(weatherData);
            }
        });

        onView(withId(R.id.activity_weather_temperature)).check(matches(withText("" + weatherData.getTemperature())));
        onView(withId(R.id.activity_weather_sunrise_hour)).check(matches(withText(weatherData.getSunriseHour().toString())));
        onView(withId(R.id.activity_weather_sunset_hour)).check(matches(withText(weatherData.getSunsetHour().toString())));

        // TODO: test symbol night
        onView(withId(R.id.activity_weather_type)).check(matches(withText(weatherData.getWeatherType().getSymbolDay())));
    }
}