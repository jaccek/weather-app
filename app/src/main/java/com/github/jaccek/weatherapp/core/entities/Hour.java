package com.github.jaccek.weatherapp.core.entities;

/**
 * Object representing hour of a day.
 */
public class Hour
{
    private int mHour;
    private int mMinute;

    public Hour(int pHour, int pMinute)
    {
        mHour = pHour;
        mMinute = pMinute;
    }

    @Override
    public String toString()
    {
        // TODO: add possibility to change format
        return mHour + ":" + mMinute;
    }

    public int getHour()
    {
        return mHour;
    }

    public void setHour(int pHour)
    {
        mHour = pHour;
    }

    public int getMinute()
    {
        return mMinute;
    }

    public void setMinute(int pMinute)
    {
        mMinute = pMinute;
    }
}
