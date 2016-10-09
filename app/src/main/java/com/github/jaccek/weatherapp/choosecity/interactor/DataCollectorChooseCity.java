package com.github.jaccek.weatherapp.choosecity.interactor;

import android.support.annotation.NonNull;

import com.github.jaccek.weatherapp.choosecity.interactor.network.ConnectorChooseCity;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.network.data.converter.ConverterCity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacek on 10/8/16.
 */
public class DataCollectorChooseCity
{
    private ConnectorChooseCity mConnector;
    private ConverterCity mConverterCity;

    public DataCollectorChooseCity(ConnectorChooseCity pConnector, ConverterCity pConverterCity)
    {
        mConnector = pConnector;
        mConverterCity = pConverterCity;
    }

    public List<City> getCities() throws ExceptionNetwork
    {
        List<RawCity> rawCities = mConnector.downloadCities();
        return convertCities(rawCities);
    }

    @NonNull
    private List<City> convertCities(List<RawCity> pRawCities)
    {
        final List<City> convertedCities = new ArrayList<>();
        for (RawCity rawCity : pRawCities)
        {
            try
            {
                City city = mConverterCity.convert(rawCity);
                convertedCities.add(city);
            }
            catch(ExceptionConversion pException)
            {
                pException.printStackTrace();
                // just ignore this city
            }
        }
        return convertedCities;
    }
}
