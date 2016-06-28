package com.github.jaccek.weatherapp.network.data.yahooweather.json;


import com.google.gson.stream.JsonReader;

import org.junit.Test;

import java.io.StringReader;

import static junit.framework.Assert.assertEquals;

/**
 * {@link StringToTimestampJsonAdapter} test.
 */
public class StringToTimestampJsonAdapterTest
{

    @Test
    public void testRead() throws Exception
    {
        String json = "[\"9:24 pm\"]";
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginArray();

        StringToTimestampJsonAdapter adapter = new StringToTimestampJsonAdapter();
        long timestamp = adapter.read(reader);

        assertEquals(73440000L, timestamp);
    }
}