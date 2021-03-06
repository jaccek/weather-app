package com.github.jaccek.weatherapp.network.models.converter;

import com.github.jaccek.weatherapp.models.Hour;
import com.github.jaccek.weatherapp.models.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.models.RawHour;

/**
 * Created by jacek on 10/2/16.
 */

public class ConverterHour
{
    public Hour convert(RawHour pRawHour) throws ExceptionConversion
    {
        if (pRawHour == null)
        {
            throw new ExceptionConversion("Raw hour is null");
        }

        return new Hour(pRawHour.getHour(), pRawHour.getMinutes());
    }
}
