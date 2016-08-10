package com.github.jaccek.weatherapp.frameworks.network.data.wpweather.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by jacek on 8/9/16.
 */
public class JsonAdapterTimestampToCalendar extends TypeAdapter<Calendar>
{
    @Override
    public void write(JsonWriter out, Calendar value) throws IOException
    {
        // not used
    }

    @Override
    public Calendar read(JsonReader in) throws IOException
    {
        Long timestampMillis = in.nextLong() * 1000L;

        Calendar result = Calendar.getInstance();
        result.setTimeInMillis(timestampMillis);

        return result;
    }
}
