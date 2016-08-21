package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.actualweather.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawCity;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jacek on 8/21/16.
 */
public class DataCollectorActualWeatherTest
{
    DataCollectorActualWeather mDataCollector;
    @Mock
    ConnectorActualWeather mConnector;
    @Mock
    ConverterCity mConverter;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mDataCollector = new DataCollectorActualWeather(mConnector, mConverter);
    }

    @Test
    public void testGetUserCitySuccess() throws Exception
    {
        City city = new City();
        RawCity rawCity = new RawCity();
        when(mConnector.downloadCity(anyInt())).thenReturn(rawCity);
        when(mConverter.convert(rawCity)).thenReturn(city);

        City returnedCity = mDataCollector.getUserCity();

        assertEquals(city, returnedCity);
        verify(mConnector).downloadCity(anyInt());  // TODO: change anyInt() to concrete city id
        verify(mConverter).convert(rawCity);
    }

    @Test(expected = ExceptionNetwork.class)
    public void testRequestUserCityFailDownloading() throws Exception
    {
        when(mConnector.downloadCity(anyInt())).thenThrow(ExceptionNetwork.class);
        mDataCollector.getUserCity();
    }

    @Test(expected = ExceptionConversion.class)
    public void testRequestUserCityFailConversion() throws Exception
    {
        RawCity rawCity = new RawCity();
        when(mConnector.downloadCity(anyInt())).thenReturn(rawCity);
        when(mConverter.convert(rawCity)).thenThrow(ExceptionConversion.class);

        mDataCollector.getUserCity();
    }
}