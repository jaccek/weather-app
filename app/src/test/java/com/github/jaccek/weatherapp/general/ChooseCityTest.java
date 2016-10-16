package com.github.jaccek.weatherapp.general;

import com.github.jaccek.weatherapp.managers.DataCollectorChooseCityTest;
import com.github.jaccek.weatherapp.interactors.InteractorChooseCityTest;
import com.github.jaccek.weatherapp.presenters.PresenterChooseCityTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by jacek on 10/15/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PresenterChooseCityTest.class,
        InteractorChooseCityTest.class,
        DataCollectorChooseCityTest.class
})
public class ChooseCityTest
{
}
