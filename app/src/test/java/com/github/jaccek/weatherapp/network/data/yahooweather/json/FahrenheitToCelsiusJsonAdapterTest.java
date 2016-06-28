package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.google.gson.stream.JsonReader;

import org.junit.Test;

import java.io.StringReader;

import static junit.framework.Assert.assertEquals;

/**
 * Test for {@link FahrenheitToCelsiusJsonAdapter}.
 */
public class FahrenheitToCelsiusJsonAdapterTest
{
    @Test
    public void testRead() throws Exception
    {
        String json = "[\"212.0\", 212.0]";
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginArray();

        FahrenheitToCelsiusJsonAdapter adapter = new FahrenheitToCelsiusJsonAdapter();

        float temperature = adapter.read(reader);
        assertEquals(100.0f, temperature, 0.001f);

        temperature = adapter.read(reader);
        assertEquals(100.0f, temperature, 0.001f);
    }
}