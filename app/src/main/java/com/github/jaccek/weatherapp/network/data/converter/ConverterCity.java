package com.github.jaccek.weatherapp.network.data.converter;

import com.github.jaccek.weatherapp.actualweather.data.City;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;

/**
 * Created by jacek on 8/20/16.
 */
public class ConverterCity
{
    public City convert(RawCity pRawCity) throws ExceptionConversion
    {
        // TODO: remove this hardcoded city
        City city = new City();
        city.setName("Warszawa");
        return city;
    }
}
