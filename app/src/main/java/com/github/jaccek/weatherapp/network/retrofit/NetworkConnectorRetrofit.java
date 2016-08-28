package com.github.jaccek.weatherapp.network.retrofit;

import com.github.jaccek.weatherapp.actualweather.interactor.network.ConnectorActualWeather;
import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.data.RawCitiesList;
import com.github.jaccek.weatherapp.network.data.RawCity;
import com.github.jaccek.weatherapp.network.data.RawWeatherData;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
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
        // TODO: refactor - broken SRP
        try
        {
            Call<RawCitiesList> call = mWsInterface.downloadCities();
            Response<RawCitiesList> response = call.execute();
            if (response.code() != 200)
            {
                throw new ExceptionNetwork(response.code());
            }

            RawCitiesList data = response.body();
            if (data == null || data.getCities() == null || data.getCities().size() == 0)
            {
                throw new ExceptionNetwork("Empty response");
            }
            return data.getCities();
        }
        catch(IOException pException)
        {
            throw new ExceptionNetwork(pException);
        }
    }

    @Override
    public RawWeatherData downloadWeatherData(int pId)
    {
        return null;
    }
}
