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
        RawCity rawCity = mConnector.downloadCity(43116);
        return mConverterCity.convert(rawCity);
    }

    public ActualWeatherData getActualWeatherData(City pCity) throws ExceptionNetwork, ExceptionConversion
    {
        RawWeatherData rawWeather = mConnector.downloadWeatherData(pCity.getId());
        return mConverterActualWeather.convert(rawWeather);
    }
}
