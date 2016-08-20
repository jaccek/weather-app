package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.json;

import com.github.jaccek.weatherapp.core.entities.Hour;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by jacek on 8/14/16.
 */
public class JsonAdapterStringToHour extends TypeAdapter<Hour>
{
    @Override
    public void write(JsonWriter out, Hour value) throws IOException
    {
        // not used
    }

    @Override
    public Hour read(JsonReader in) throws IOException
    {
        try
        {
            String hourString = in.nextString();
            String[] hourParts = hourString.split(":");
            int hour = Integer.parseInt(hourParts[0]);
            int minutes = Integer.parseInt(hourParts[1]);

            return new Hour(hour, minutes);
        }
        catch(Exception pE)
        {
            pE.printStackTrace();
            return null;
        }
    }
}
