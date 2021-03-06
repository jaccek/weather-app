package com.github.jaccek.weatherapp.network.retrofit;

import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.models.RawCitiesList;
import com.github.jaccek.weatherapp.network.models.RawCity;
import com.github.jaccek.weatherapp.network.models.RawWeatherData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jacek on 8/21/16.
 */
public class NetworkConnectorRetrofitTest
{
    NetworkConnectorRetrofit mConnector;
    @Mock
    WebServiceInterface mWebServiceInterface;
    @Mock
    Call<RawCitiesList> mCallCities;
    @Mock
    Call<RawWeatherData> mCallWeatherData;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init() throws NoSuchFieldException, IllegalAccessException
    {
        mConnector = new NetworkConnectorRetrofit();

        Field wsInterface = mConnector.getClass().getDeclaredField("mWsInterface");
        wsInterface.setAccessible(true);
        wsInterface.set(mConnector, mWebServiceInterface);
    }

    @Test
    public void testDownloadCitySuccess() throws Exception
    {
        List<RawCity> cities = new ArrayList<>();
        cities.add(new RawCity());
        cities.add(new RawCity());
        RawCitiesList responseBody = new RawCitiesList();
        responseBody.setCities(cities);
        Response<RawCitiesList> response = Response.success(responseBody);

        when(mWebServiceInterface.downloadCities()).thenReturn(mCallCities);
        when(mCallCities.execute()).thenReturn(response);

        List<RawCity> returnedCities = mConnector.downloadCities();

        assertEquals(cities, returnedCities);
        assertEquals(cities.size(), returnedCities.size());
        verify(mWebServiceInterface).downloadCities();
    }

    @Test(expected = ExceptionNetwork.class)
    public void testDownloadCityEmptyResponse() throws Exception
    {
        Response<RawCitiesList> response = Response.success(null);
        when(mWebServiceInterface.downloadCities()).thenReturn(mCallCities);
        when(mCallCities.execute()).thenReturn(response);

        mConnector.downloadCities();
    }

    @Test(expected = ExceptionNetwork.class)
    public void testDownloadCity404() throws Exception
    {
        ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), "");
        Response<RawCitiesList> response = Response.error(404, responseBody);
        when(mWebServiceInterface.downloadCities()).thenReturn(mCallCities);
        when(mCallCities.execute()).thenReturn(response);

        mConnector.downloadCities();
    }

    @Test
    public void testDownloadWeatherDataSuccess() throws Exception
    {
        final int cityId = 43116;
        RawWeatherData rawWeatherData = new RawWeatherData();
        Response<RawWeatherData> response = Response.success(rawWeatherData);
        when(mWebServiceInterface.downloadWeatherData(cityId)).thenReturn(mCallWeatherData);
        when(mCallWeatherData.execute()).thenReturn(response);

        RawWeatherData returnedData = mConnector.downloadWeatherData(cityId);

        assertEquals(rawWeatherData, returnedData);
        verify(mWebServiceInterface).downloadWeatherData(cityId);
    }

    @Test(expected = ExceptionNetwork.class)
    public void testDownloadWeatherDataEmptyResponse() throws Exception
    {
        final int cityId = 43116;
        Response<RawWeatherData> response = Response.success(null);
        when(mWebServiceInterface.downloadWeatherData(cityId)).thenReturn(mCallWeatherData);
        when(mCallWeatherData.execute()).thenReturn(response);

        mConnector.downloadWeatherData(cityId);
    }

    @Test(expected = ExceptionNetwork.class)
    public void testDownloadWeatherData404() throws Exception
    {
        final int cityId = 43116;
        ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), "");
        Response<RawWeatherData> response = Response.error(404, responseBody);
        when(mWebServiceInterface.downloadWeatherData(cityId)).thenReturn(mCallWeatherData);
        when(mCallWeatherData.execute()).thenReturn(response);

        mConnector.downloadWeatherData(cityId);
    }
}