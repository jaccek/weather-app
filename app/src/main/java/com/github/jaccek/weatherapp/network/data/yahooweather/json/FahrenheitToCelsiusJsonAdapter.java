package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.github.jaccek.weatherapp.utils.UnitConverter;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * {@link TypeAdapter} that converts temperature unit from Fahernheit to Celcius.
 */
public class FahrenheitToCelsiusJsonAdapter extends TypeAdapter<Float>
{
    @Override
    public void write(JsonWriter out, Float value) throws IOException
    {
        // not used
    }

    @Override
    public Float read(JsonReader in) throws IOException
    {
        float temperature;
        switch(in.peek())
        {
            case STRING:
                temperature = Float.parseFloat(in.nextString());
                break;

            case NUMBER:
                temperature = (float) in.nextDouble();
                break;

            default:
                throw new IOException("Bad token type");
        }

        return UnitConverter.fahrenheitToCelsius(temperature);
    }
}
