package com.github.jaccek.weatherapp.network.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jacek on 8/21/16.
 */
public class RawCitiesList
{
    @SerializedName("cities")
    private List<RawCity> mCities;

    public List<RawCity> getCities()
    {
        return mCities;
    }

    public void setCities(List<RawCity> pCities)
    {
        mCities = pCities;
    }
}
