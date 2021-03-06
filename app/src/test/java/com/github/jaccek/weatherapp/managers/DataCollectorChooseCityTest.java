package com.github.jaccek.weatherapp.managers;

import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.models.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.connectors.ConnectorChooseCity;
import com.github.jaccek.weatherapp.network.models.RawCity;
import com.github.jaccek.weatherapp.network.models.converter.ConverterCity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jacek on 10/9/16.
 */
public class DataCollectorChooseCityTest
{
    private DataCollectorChooseCity mDataCollector;
    @Mock
    private ConnectorChooseCity mConnector;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        ConverterCity converterCity = new ConverterCity();
        mDataCollector = new DataCollectorChooseCity(mConnector, converterCity);
    }

    @Test
    public void testGetCities_success() throws Exception
    {
        List<RawCity> rawCities = new ArrayList<>();
        rawCities.add(new RawCity(1, "Test"));
        rawCities.add(new RawCity(2, "Warszawa"));
        when(mConnector.downloadCities()).thenReturn(rawCities);

        List<City> cities = mDataCollector.getCities();

        assertEquals(rawCities.size(), cities.size());
        for (int i = 0; i < rawCities.size(); ++i)
        {
            assertEquals(rawCities.get(i).getId(), cities.get(i).getId());
            assertEquals(rawCities.get(i).getName(), cities.get(i).getName());
        }
    }

    @Test(expected = ExceptionNetwork.class)
    public void testGetCities_networkException() throws Exception
    {
        when(mConnector.downloadCities()).thenThrow(ExceptionNetwork.class);
        mDataCollector.getCities();
    }

    @Test
    public void testGetCities_conversionException() throws Exception
    {
        ConverterCity converterMock = mock(ConverterCity.class);
        mDataCollector = new DataCollectorChooseCity(mConnector, converterMock);

        List<RawCity> rawCities = new ArrayList<>();
        rawCities.add(new RawCity(1, "Test"));
        rawCities.add(new RawCity(2, "Warszawa"));

        when(mConnector.downloadCities()).thenReturn(rawCities);
        when(converterMock.convert(rawCities.get(0))).thenCallRealMethod();
        when(converterMock.convert(rawCities.get(1))).thenThrow(ExceptionConversion.class);

        List<City> cities = mDataCollector.getCities();

        assertEquals(rawCities.size() - 1, cities.size());
        for (int i = 0; i < cities.size(); ++i)
        {
            assertEquals(rawCities.get(i).getId(), cities.get(i).getId());
            assertEquals(rawCities.get(i).getName(), cities.get(i).getName());
        }
    }
}