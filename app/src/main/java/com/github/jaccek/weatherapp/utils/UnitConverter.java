package com.github.jaccek.weatherapp.utils;

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
}
