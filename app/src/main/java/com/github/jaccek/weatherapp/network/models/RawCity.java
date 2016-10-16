package com.github.jaccek.weatherapp.network.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jacek on 8/20/16.
 */
public class RawCity
{
    @SerializedName("cid")
    private int mId;
    @SerializedName("name")
    private String mName;

    public RawCity()
    {
    }

    public RawCity(int pId, String pName)
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

    public String getName()
    {
        return mName;
    }
}
