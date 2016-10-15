package com.github.jaccek.weatherapp.network;

import com.github.jaccek.weatherapp.network.data.converter.ConverterActualWeatherTest;
import com.github.jaccek.weatherapp.network.data.converter.ConverterHourTest;
import com.github.jaccek.weatherapp.network.data.converter.ConverterWeatherTypeTest;
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
