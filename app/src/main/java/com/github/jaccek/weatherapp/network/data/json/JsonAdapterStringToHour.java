package com.github.jaccek.weatherapp.network.data.json;

import com.github.jaccek.weatherapp.network.data.RawHour;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by jacek on 10/2/16.
 */
public class JsonAdapterStringToHour extends TypeAdapter<RawHour>
{
    @Override
    public void write(JsonWriter out, RawHour value) throws IOException
    {
        // not used
    }

    @Override
    public RawHour read(JsonReader in) throws IOException
    {
        String hourStr = in.nextString();
        String parts[] = hourStr.split(":");

        RawHour hour = new RawHour();
        hour.setHour(Integer.parseInt(parts[0]));
        hour.setMinutes(Integer.parseInt(parts[1]));
        return hour;
    }
}
