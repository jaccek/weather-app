package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Converts string (eg. "9:24 pm") to timestamp.
 */
public class StringToTimestampJsonAdapter extends TypeAdapter<Long>
{
    private SimpleDateFormat mFormatter = new SimpleDateFormat("KK:mm aa", Locale.getDefault());

    @Override
    public void write(JsonWriter out, Long value) throws IOException
    {
        // not used
    }

    @Override
    public Long read(JsonReader in) throws IOException
    {
        String hour = in.nextString();

        try
        {
            return mFormatter.parse(hour).getTime();
        }
        catch(ParseException ex)
        {
            throw new IOException(ex);
        }
    }
}
