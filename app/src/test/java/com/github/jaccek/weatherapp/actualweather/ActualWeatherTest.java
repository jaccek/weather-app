package com.github.jaccek.weatherapp.actualweather;

import com.github.jaccek.weatherapp.actualweather.interactor.DataCollectorActualWeatherTest;
import com.github.jaccek.weatherapp.actualweather.interactor.InteractorActualWeatherTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by jacek on 10/15/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PresenterActualWeatherTest.class,
        InteractorActualWeatherTest.class,
        DataCollectorActualWeatherTest.class
})
public class ActualWeatherTest
{
}
