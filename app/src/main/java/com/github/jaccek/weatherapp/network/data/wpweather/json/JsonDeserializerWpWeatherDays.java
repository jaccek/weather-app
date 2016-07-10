package com.github.jaccek.weatherapp.network.data.wpweather.json;

import com.github.jaccek.weatherapp.network.data.wpweather.WpWeatherDay;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Deserializer for list of {@link WpWeatherDay}.
 */
public class JsonDeserializerWpWeatherDays implements JsonDeserializer<List<WpWeatherDay>>
{
    @Override
    public List<WpWeatherDay> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException
    {
        List<WpWeatherDay> weatherDays = new ArrayList<>();

        if (!json.isJsonObject())
        {
            return null;
        }

        JsonObject object = (JsonObject) json;
        for (Map.Entry<String, JsonElement> element : object.entrySet())
        {
            WpWeatherDay day = context.deserialize(element.getValue(), WpWeatherDay.class);
            weatherDays.add(day);
        }

        return weatherDays;
    }
}
