package com.github.jaccek.weatherapp.general;

import com.github.jaccek.weatherapp.managers.DataCollectorActualWeatherTest;
import com.github.jaccek.weatherapp.interactors.InteractorActualWeatherTest;
import com.github.jaccek.weatherapp.presenters.PresenterActualWeatherTest;

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
