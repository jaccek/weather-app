package com.github.jaccek.weatherapp.managers;

import com.github.jaccek.weatherapp.models.ActualWeatherData;
import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.network.connectors.ConnectorActualWeather;
import com.github.jaccek.weatherapp.models.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.models.RawCity;
import com.github.jaccek.weatherapp.network.models.RawWeatherData;
import com.github.jaccek.weatherapp.network.models.converter.ConverterActualWeather;
import com.github.jaccek.weatherapp.network.models.converter.ConverterCity;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

/**
 * Responsibility: providing data for actual weather module
 *
 * TODO: introduce database
 */
public class DataCollectorActualWeather
{
    private ConnectorActualWeather mConnector;
    private ConverterCity mConverterCity;
    private ConverterActualWeather mConverterActualWeather;

    @Inject
    public DataCollectorActualWeather(ConnectorActualWeather pConnector,
                                      ConverterCity pConverter,
                                      ConverterActualWeather pConverterActualWeather)
    {
        mConnector = pConnector;
        mConverterCity = pConverter;
        mConverterActualWeather = pConverterActualWeather;
    }

    public City getUserCity() throws ExceptionNetwork, ExceptionConversion
    {
        // TODO: city id of Warsaw - change it
        final int warsawCityId = 43116;
        List<RawCity> rawCities = mConnector.downloadCities();

        for (RawCity city : rawCities)
        {
            if (city.getId() == warsawCityId)
            {
                return mConverterCity.convert(city);
            }
        }
        throw new ExceptionNetwork("Cannot find city with id = " + warsawCityId);
    }

    public ActualWeatherData getActualWeatherData(City pCity) throws ExceptionNetwork, ExceptionConversion
    {
        RawWeatherData rawWeather = mConnector.downloadWeatherData(pCity.getId());
        return mConverterActualWeather.convert(rawWeather, Calendar.getInstance());
    }
}
