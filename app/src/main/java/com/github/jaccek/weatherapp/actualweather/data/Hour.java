package com.github.jaccek.weatherapp.actualweather.data;

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
}
