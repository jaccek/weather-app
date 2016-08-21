package com.github.jaccek.weatherapp.actualweather.interactor;

import com.github.jaccek.weatherapp.actualweather.data.ActualWeatherData;
import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.actualweather.data.converter.ConverterCity;
import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.actualweather.interactor.network.data.RawCity;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;

/**
 * Responsibility: providing data for actual weather module
 *
 * TODO: introduce database
 */
public class DataCollectorActualWeather
{
    private ConnectorActualWeather mConnector;
    private ConverterCity mConverter;

    public DataCollectorActualWeather(ConnectorActualWeather pConnector, ConverterCity pConverter)
    {
        mConnector = pConnector;
        mConverter = pConverter;
    }

    public City getUserCity() throws ExceptionNetwork, ExceptionConversion
    {
        // TODO: city id of Warsaw - change it
        RawCity rawCity = mConnector.downloadCity(43116);
        return mConverter.convert(rawCity);
    }

    public ActualWeatherData getActualWeatherData(City pCity) throws ExceptionNetwork, ExceptionConversion
    {
        // TODO: implement
        return null;
    }
}
