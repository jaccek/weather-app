package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.actualweather.data.converter.ConverterActualWeather;
import com.github.jaccek.weatherapp.actualweather.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawCity;
import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawWeatherData;
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
    ConverterCity mConverterCity;
    @Mock
    ConverterActualWeather mConverterActualWeather;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mDataCollector = new DataCollectorActualWeather(mConnector, mConverterCity, mConverterActualWeather);
    }

    @Test
    public void testGetUserCitySuccess() throws Exception
    {
        City city = new City();
        RawCity rawCity = new RawCity();
        when(mConnector.downloadCity(anyInt())).thenReturn(rawCity);
        when(mConverterCity.convert(rawCity)).thenReturn(city);

        City returnedCity = mDataCollector.getUserCity();

        assertEquals(city, returnedCity);
        verify(mConnector).downloadCity(anyInt());  // TODO: change anyInt() to concrete city id
        verify(mConverterCity).convert(rawCity);
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
        when(mConverterCity.convert(rawCity)).thenThrow(ExceptionConversion.class);

        mDataCollector.getUserCity();
    }

    @Test
    public void testRequestActualWeatherDataSuccess() throws Exception
    {
        int cityId = 124;
        City city = new City();
        city.setId(cityId);
        RawWeatherData rawWeather = new RawWeatherData();
        ActualWeatherData actualWeather = new ActualWeatherData();
        when(mConnector.downloadWeatherData(cityId)).thenReturn(rawWeather);
        when(mConverterActualWeather.convert(rawWeather)).thenReturn(actualWeather);

        ActualWeatherData returnedWeather = mDataCollector.getActualWeatherData(city);

        assertEquals(actualWeather, returnedWeather);
        verify(mConnector).downloadWeatherData(cityId);
        verify(mConverterActualWeather).convert(rawWeather);
    }

    @Test(expected = ExceptionNetwork.class)
    public void testRequestActualWeatherDataFailDownloading() throws Exception
    {
        int cityId = 124;
        City city = new City();
        city.setId(cityId);
        when(mConnector.downloadWeatherData(cityId)).thenThrow(ExceptionNetwork.class);

        mDataCollector.getActualWeatherData(city);
    }

    @Test(expected = ExceptionConversion.class)
    public void testRequestActualWeatherDataFailConversion() throws Exception
    {
        int cityId = 124;
        City city = new City();
        city.setId(cityId);
        RawWeatherData rawWeather = new RawWeatherData();
        when(mConnector.downloadWeatherData(cityId)).thenReturn(rawWeather);
        when(mConverterActualWeather.convert(rawWeather)).thenThrow(ExceptionConversion.class);

        mDataCollector.getActualWeatherData(city);
    }
}