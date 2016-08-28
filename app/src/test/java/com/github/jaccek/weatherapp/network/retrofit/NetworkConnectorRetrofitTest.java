package com.github.jaccek.weatherapp.network.retrofit;

import com.github.jaccek.weatherapp.network.data.RawCity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

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
        List<RawCity> returnedCities = mConnector.downloadCities();

        assertTrue(returnedCities != null);
        assertTrue(returnedCities.size() > 0);
    }

    // TODO: test empty response
    // TODO: test IOException etc.
}