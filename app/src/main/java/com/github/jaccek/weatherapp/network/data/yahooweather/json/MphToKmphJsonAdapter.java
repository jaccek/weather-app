package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.github.jaccek.weatherapp.utils.UnitConverter;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Json adapter that converts mph to km/h.
 */
public class MphToKmphJsonAdapter extends TypeAdapter<Float>
{
    @Override
    public void write(JsonWriter out, Float value) throws IOException
    {
        // not used
    }

    @Override
    public Float read(JsonReader in) throws IOException
    {
        float value;
        JsonToken token = in.peek();

        switch (token)
        {
            case STRING:
                value = Float.parseFloat(in.nextString());
                break;

            case NUMBER:
                value = (float) in.nextDouble();
                break;

            default:
                throw new IOException("Bad token type");
        }

        return UnitConverter.mphToKmph(value);
    }
}
