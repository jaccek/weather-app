package com.github.jaccek.weatherapp.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This class contains method to convert units of some measurements like temperature, speed etc.
 */
public class UnitConverter
{
    /**
     * Converts temperature measure from Fahrenheit to Celsius scale.
     *
     * @param pFahrenheit Temperature in Fahrenheit.
     * @return Temperature in Celsius.
     */
    public static float fahrenheitToCelsius(float pFahrenheit)
    {
        return (pFahrenheit - 32.0f) / 1.8f;
    }

    /**
     * Converts velocity from mph to km/h.
     *
     * @param pVelocity Velocity in mph.
     * @return Velocity in km/h.
     */
    public static float mphToKmph(float pVelocity)
    {
        return pVelocity * 1.609344f;
    }

    /**
     * Converts timestamp to date in format dd.MM.yyyy.
     *
     * @param pTimestamp Timestamp.
     * @return Date in format dd.MM.yyyy.
     */
    public static String timestampToDate(long pTimestamp)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return format.format(new Date(pTimestamp));
    }

    /**
     * Converts timestamp to hour in format "h:mm a" (eg. 11:23 am).
     *
     * @param pTimestamp Timestamp.
     * @return Formatted hour.
     */
    public static String timestampToHour(long pTimestamp)
    {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a", Locale.getDefault());
        return format.format(new Date(pTimestamp)).toLowerCase(Locale.getDefault());
    }
}
