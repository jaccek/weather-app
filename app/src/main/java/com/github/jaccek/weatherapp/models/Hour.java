package com.github.jaccek.weatherapp.models;

/**
 * Created by jacek on 10/2/16.
 */
public class Hour
{
    private int mHour;
    private int mMinutes;

    public Hour()
    {
    }

    public Hour(int pHour, int pMinutes)
    {
        mHour = pHour;
        mMinutes = pMinutes;
    }

    public int getHour()
    {
        return mHour;
    }

    public int getMinutes()
    {
        return mMinutes;
    }

    @Override
    public String toString()
    {
        String leadingZero = mMinutes < 10 ? "0" : "";
        return mHour + ":" + leadingZero + mMinutes;
    }
}
