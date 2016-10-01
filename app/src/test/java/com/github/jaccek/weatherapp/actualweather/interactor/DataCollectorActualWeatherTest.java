package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.network.data.RawWeatherData;
import com.github.jaccek.weatherapp.network.data.converter.ConverterActualWeather;
import com.github.jaccek.weatherapp.network.data.converter.ConverterCity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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
        List<RawCity> rawCities = new ArrayList<>();
        RawCity rawCity = new RawCity();
        rawCity.setId(43116);
        rawCities.add(rawCity);

        when(mConnector.downloadCities()).thenReturn(rawCities);
        when(mConverterCity.convert(rawCity)).thenReturn(city);

        City returnedCity = mDataCollector.getUserCity();

        assertEquals(city, returnedCity);
        verify(mConnector).downloadCities();
        verify(mConverterCity).convert(rawCity);
    }

    @Test(expected = ExceptionNetwork.class)
    public void testRequestUserCityFailDownloading() throws Exception
    {
        when(mConnector.downloadCities()).thenThrow(ExceptionNetwork.class);
        mDataCollector.getUserCity();
    }

    @Test(expected = ExceptionConversion.class)
    public void testRequestUserCityFailConversion() throws Exception
    {
        List<RawCity> rawCities = new ArrayList<>();
        RawCity rawCity = new RawCity();
        rawCity.setId(43116);
        rawCities.add(rawCity);
        when(mConnector.downloadCities()).thenReturn(rawCities);
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
        when(mConverterActualWeather.convert(eq(rawWeather), any(Calendar.class))).thenReturn(actualWeather);

        ActualWeatherData returnedWeather = mDataCollector.getActualWeatherData(city);

        assertEquals(actualWeather, returnedWeather);
        verify(mConnector).downloadWeatherData(cityId);
        verify(mConverterActualWeather).convert(eq(rawWeather), any(Calendar.class));
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
        when(mConverterActualWeather.convert(eq(rawWeather), any(Calendar.class))).thenThrow(ExceptionConversion.class);

        mDataCollector.getActualWeatherData(city);
    }
}