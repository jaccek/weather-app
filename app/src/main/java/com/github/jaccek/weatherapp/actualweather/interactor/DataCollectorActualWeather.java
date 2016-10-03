package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.data.ActualWeatherData;
import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.network.data.RawWeatherData;
import com.github.jaccek.weatherapp.network.data.converter.ConverterActualWeather;
import com.github.jaccek.weatherapp.network.data.converter.ConverterCity;

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
