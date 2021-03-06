package com.github.jaccek.weatherapp.network.retrofit;

import android.support.annotation.NonNull;

import com.github.jaccek.weatherapp.network.connectors.ConnectorActualWeather;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.models.RawCitiesList;
import com.github.jaccek.weatherapp.network.models.RawCity;
import com.github.jaccek.weatherapp.network.models.RawWeatherData;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jacek on 8/21/16.
 */
public class NetworkConnectorRetrofit implements
        ConnectorActualWeather
{
    private WebServiceInterface mWsInterface;

    @Inject
    public NetworkConnectorRetrofit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pogoda.wp.pl/api/o2/mobile/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mWsInterface = retrofit.create(WebServiceInterface.class);
    }

    @Override
    public List<RawCity> downloadCities() throws ExceptionNetwork
    {
        Response<RawCitiesList> response = sendRequestForCitiesList();
        return getCitiesFromResponse(response);
    }

    private Response<RawCitiesList> sendRequestForCitiesList() throws ExceptionNetwork
    {
        try
        {
            Response<RawCitiesList> response = mWsInterface.downloadCities().execute();
            return response;
        }
        catch(IOException pException)
        {
            throw new ExceptionNetwork(pException);
        }
    }

    private List<RawCity> getCitiesFromResponse(Response<RawCitiesList> pResponse) throws ExceptionNetwork
    {
        if(pResponse.code() != 200)
        {
            throw new ExceptionNetwork(pResponse.code());
        }

        RawCitiesList data = pResponse.body();
        if(data == null || data.getCities() == null || data.getCities().size() == 0)
        {
            throw new ExceptionNetwork("Empty response");
        }
        return data.getCities();
    }

    @Override
    public RawWeatherData downloadWeatherData(int pCityId) throws ExceptionNetwork
    {
        Response<RawWeatherData> response = getWeatherDataResponse(pCityId);
        return getWeatherDataFromResponse(response);
    }

    @NonNull
    private RawWeatherData getWeatherDataFromResponse(Response<RawWeatherData> pResponse) throws ExceptionNetwork
    {
        if(pResponse.code() != 200)
        {
            throw new ExceptionNetwork(pResponse.code());
        }

        RawWeatherData data = pResponse.body();
        if(data == null)
        {
            throw new ExceptionNetwork("Empty response");
        }
        return data;
    }

    private Response<RawWeatherData> getWeatherDataResponse(int pCityId) throws ExceptionNetwork
    {
        try
        {
            return mWsInterface.downloadWeatherData(pCityId).execute();
        }
        catch(IOException pException)
        {
            throw new ExceptionNetwork(pException);
        }
    }
}
