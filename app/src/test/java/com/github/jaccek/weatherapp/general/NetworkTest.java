package com.github.jaccek.weatherapp.general;

import com.github.jaccek.weatherapp.network.models.converter.ConverterActualWeatherTest;
import com.github.jaccek.weatherapp.network.models.converter.ConverterHourTest;
import com.github.jaccek.weatherapp.network.models.converter.ConverterWeatherTypeTest;
import com.github.jaccek.weatherapp.network.retrofit.NetworkConnectorRetrofitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by jacek on 10/15/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        NetworkConnectorRetrofitTest.class,
        ConverterHourTest.class,
        ConverterWeatherTypeTest.class,
        ConverterActualWeatherTest.class
})
public class NetworkTest
{
}
