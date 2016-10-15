package com.github.jaccek.weatherapp.choosecity;

import com.github.jaccek.weatherapp.choosecity.interactor.DataCollectorChooseCityTest;
import com.github.jaccek.weatherapp.choosecity.interactor.InteractorChooseCityTest;

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
