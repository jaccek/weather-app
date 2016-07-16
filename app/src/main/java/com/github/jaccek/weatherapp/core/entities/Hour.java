package com.github.jaccek.weatherapp.core.entities;

/**
 * Object representing hour of a day.
 */
public class Hour
{
    private int mHour;
    private int mMinute;

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
