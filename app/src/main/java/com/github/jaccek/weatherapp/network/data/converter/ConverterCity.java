package com.github.jaccek.weatherapp.network.data.converter;

import com.github.jaccek.weatherapp.data.City;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;

/**
 * Created by jacek on 8/20/16.
 */
public class ConverterCity
{
    // TODO: test it!!!
    public City convert(RawCity pRawCity) throws ExceptionConversion
    {
        if (pRawCity.getId() <= 0)
        {
            throw new ExceptionConversion("City without id");
        }
        if (pRawCity.getName() == null || pRawCity.getName().isEmpty())
        {
            throw new ExceptionConversion("City without name");
        }

        City city = new City();
        city.setId(pRawCity.getId());
        city.setName(pRawCity.getName());
        return city;
    }
}
