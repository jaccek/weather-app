package com.github.jaccek.weatherapp.network.data;

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
