package com.github.jaccek.weatherapp.network.data.converter;

import android.support.annotation.NonNull;

import com.github.jaccek.weatherapp.data.ActualWeatherData;
import com.github.jaccek.weatherapp.converter.ExceptionConversion;
import com.github.jaccek.weatherapp.network.data.RawWeatherDay;
import com.github.jaccek.weatherapp.network.data.RawWeatherData;
import com.github.jaccek.weatherapp.network.data.RawWeatherPeriod;

import java.util.Calendar;
import java.util.List;

/**
 * Created by jacek on 8/21/16.
 */
public class ConverterActualWeather
{
    private static final long MILLIS_IN_DAY = 24L * 60L * 60L * 1000L;

    private ConverterHour mConverterHour = new ConverterHour();
    private ConverterWeatherType mConverterWeatherType = new ConverterWeatherType();

    public ActualWeatherData convert(RawWeatherData pRawWeather, Calendar pDate) throws ExceptionConversion
    {
        if(pRawWeather == null)
        {
            throw new ExceptionConversion("Source to convert is null");
        }

        RawWeatherDay rawDay = findWeatherDay(pRawWeather, pDate);
        RawWeatherPeriod period = findClosestWeatherPeriod(pDate, rawDay);

        return createActualWeatherData(period, rawDay);
    }

    @NonNull
    private RawWeatherDay findWeatherDay(RawWeatherData pRawWeather, Calendar pDate) throws ExceptionConversion
    {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        for(RawWeatherDay rawDay : pRawWeather.getDays())
        {
            startDate.setTimeInMillis(rawDay.getTimestamp());
            endDate.setTimeInMillis(rawDay.getTimestamp() + MILLIS_IN_DAY);

            if(pDate.after(startDate) && pDate.before(endDate))
            {
                return rawDay;
            }
        }

        throw new ExceptionConversion("Cannot find weather data for given date");
    }

    private RawWeatherPeriod findClosestWeatherPeriod(Calendar pDate, RawWeatherDay pRawDay)
    {
        int closestPeriodIdx = 0;
        long smallestTimestampDifference = Long.MAX_VALUE;
        long pDateTimestamp = pDate.getTimeInMillis();
        List<RawWeatherPeriod> periods = pRawDay.getWeatherPeriods();

        for(int i = 0; i < periods.size(); ++i)
        {
            long currentTimestampDifference = Math.abs(pDateTimestamp - periods.get(i).getTimestamp());
            if(currentTimestampDifference < smallestTimestampDifference)
            {
                smallestTimestampDifference = currentTimestampDifference;
                closestPeriodIdx = i;
            }
        }

        return periods.get(closestPeriodIdx);
    }

    @NonNull
    private ActualWeatherData createActualWeatherData(RawWeatherPeriod pPeriod, RawWeatherDay pDay)
            throws ExceptionConversion
    {
        ActualWeatherData actualWeatherData = new ActualWeatherData();
        actualWeatherData.setTemperature(pPeriod.getTemperature());
        actualWeatherData.setPressure(pPeriod.getPressure());
        actualWeatherData.setSunriseHour(mConverterHour.convert(pDay.getSunriseHour()));
        actualWeatherData.setSunsetHour(mConverterHour.convert(pDay.getSunsetHour()));
        actualWeatherData.setWeatherType(mConverterWeatherType.convert(pPeriod.getWeatherType()));
        return actualWeatherData;
    }
}
