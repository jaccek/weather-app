package com.github.jaccek.weatherapp.weather.actual;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherData;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Tests for {@link ActivityActualWeatherTest}.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityActualWeatherTest
{
    @Rule
    public ActivityTestRule<ActivityActualWeather> mActivityRule
            = new ActivityTestRule<>(ActivityActualWeather.class);

    @Test
    public void showWeatherTest()
    {
        final WpWeatherData weatherData = new WpWeatherData();
        weatherData.setTemperature(18);
        weatherData.setWindSpeed(1.693f);
        weatherData.setWeatherType(IWeatherData.WeatherType.SUNNY);

        mActivityRule.getActivity().runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                mActivityRule.getActivity().showWeather(weatherData);
            }
        });

        onView(withId(R.id.activity_weather_temperature)).check(matches(withText("18")));
        onView(withId(R.id.activity_weather_wind_speed)).check(matches(withText("1,7")));
    }

//    @Test
//    public void onCityClickedTest()
//    {
//        onView(withId(R.id.activity_weather_city)).perform(click());
//        // TODO: check if new activity started
//    }
}