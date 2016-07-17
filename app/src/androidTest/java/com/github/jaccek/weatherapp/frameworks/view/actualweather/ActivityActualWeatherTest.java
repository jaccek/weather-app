package com.github.jaccek.weatherapp.frameworks.view.actualweather;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.core.entities.City;
import com.github.jaccek.weatherapp.core.entities.Hour;
import com.github.jaccek.weatherapp.core.entities.weather.WeatherDataActual;
import com.github.jaccek.weatherapp.core.entities.weather.WeatherType;
import com.github.jaccek.weatherapp.frameworks.utils.WeatherTypeConverter;
import com.github.jaccek.weatherapp.frameworks.view.choosecity.ActivityCityChooser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
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
    public IntentsTestRule<ActivityActualWeather> mActivityRule
            = new IntentsTestRule<>(ActivityActualWeather.class);

    @Test
    public void testShowWeather()
    {
        final WeatherDataActual weatherData = new WeatherDataActual();
        weatherData.setTemperature(18);
        weatherData.setWindSpeed(1.693f);
        weatherData.setSunriseHour(new Hour(5, 15));
        weatherData.setSunsetHour(new Hour(21, 31));
        weatherData.setWeatherType(WeatherType.SUNNY);

        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable()
        {
            @Override
            public void run()
            {
                mActivityRule.getActivity().showWeather(weatherData);
            }
        });

        onView(withId(R.id.activity_weather_temperature)).check(matches(withText("18")));
        onView(withId(R.id.activity_weather_wind_speed)).check(matches(withText("1,7")));
        onView(withId(R.id.activity_weather_sunrise_hour)).check(matches(withText("5:15")));
        onView(withId(R.id.activity_weather_sunset_hour)).check(matches(withText("21:31")));
        onView(withId(R.id.activity_weather_type)).check(matches(withText(WeatherTypeConverter.toString(WeatherType.SUNNY))));
    }

    @Test
    public void testSetCity()
    {
        final City city = new City();
        String cityName = "Gdańsk";
        city.setName(cityName);

        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable()
        {
            @Override
            public void run()
            {
                mActivityRule.getActivity().setCity(city);
            }
        });

        onView(withId(R.id.activity_weather_city)).check(matches(withText(cityName)));
    }

    @Test
    public void onCityClickedTest()
    {
        onView(withId(R.id.activity_weather_city)).perform(click());
        intended(hasComponent(hasClassName(ActivityCityChooser.class.getName())));
    }
}