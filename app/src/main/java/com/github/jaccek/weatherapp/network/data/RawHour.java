package com.github.jaccek.weatherapp.network.data;

/**
 * Created by jacek on 10/2/16.
 */
public class RawHour
{
    private int mHour;
    private int mMinutes;

    public RawHour()
    {
    }

    public RawHour(int pHour, int pMinutes)
    {
        mHour = pHour;
        mMinutes = pMinutes;
    }

    public void setHour(int pHour)
    {
        mHour = pHour;
    }

    public int getHour()
    {
        return mHour;
    }

    public void setMinutes(int pMinutes)
    {
        mMinutes = pMinutes;
    }

    public int getMinutes()
    {
        return mMinutes;
    }
}
