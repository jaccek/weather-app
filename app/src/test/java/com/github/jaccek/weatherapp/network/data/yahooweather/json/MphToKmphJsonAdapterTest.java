package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.google.gson.stream.JsonReader;

import org.junit.Test;

import java.io.StringReader;

import static junit.framework.Assert.assertEquals;

/**
 * Test for {@link MphToKmphJsonAdapter}.
 */
public class MphToKmphJsonAdapterTest
{

    @Test
    public void testRead() throws Exception
    {
        String json = "[\"18\", 20]";
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginArray();

        MphToKmphJsonAdapter adapter = new MphToKmphJsonAdapter();

        float speed = adapter.read(reader);
        assertEquals(28.96819f, speed, 0.001f);

        speed = adapter.read(reader);
        assertEquals(32.18688f, speed, 0.001f);
    }
}