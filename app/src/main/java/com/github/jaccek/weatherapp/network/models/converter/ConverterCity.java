package com.github.jaccek.weatherapp.network.models.converter;

import com.github.jaccek.weatherapp.models.City;
import com.github.jaccek.weatherapp.network.models.RawCity;
import com.github.jaccek.weatherapp.models.converter.ExceptionConversion;

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
