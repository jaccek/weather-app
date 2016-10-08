package com.github.jaccek.weatherapp.data;

/**
 * Created by jacek on 8/20/16.
 */
public class City
{
    private int mId;
    private String mName;

    public City()
    {
    }

    public City(int pId, String pName)
    {
        mId = pId;
        mName = pName;
    }

    public int getId()
    {
        return mId;
    }

    public void setId(int pId)
    {
        mId = pId;
    }

    public void setName(String pName)
    {
        mName = pName;
    }

    public String getName()
    {
        return mName;
    }
}
