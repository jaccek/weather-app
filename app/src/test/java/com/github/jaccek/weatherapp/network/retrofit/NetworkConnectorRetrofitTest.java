package com.github.jaccek.weatherapp.network.retrofit;

import com.github.jaccek.weatherapp.network.data.RawCity;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jacek on 8/21/16.
 */
public class NetworkConnectorRetrofitTest
{
    NetworkConnectorRetrofit mConnector;

    @Before
    public void init()
    {
        mConnector = new NetworkConnectorRetrofit();
    }

    @Test
    public void testDownloadCity() throws Exception
    {
        int cityId = 43116;

        RawCity returnedCity = mConnector.downloadCity(cityId);

        assertEquals(cityId, returnedCity.getId());
        assertEquals("Warszawa", returnedCity.getName());
    }

    // TODO: test empty response
    // TODO: test IOException etc.
}