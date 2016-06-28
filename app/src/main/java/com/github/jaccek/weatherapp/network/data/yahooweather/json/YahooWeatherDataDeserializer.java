package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.github.jaccek.weatherapp.network.data.yahooweather.YahooWeatherData;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializer for data from Yahoo Weather. It allows to not implement some not useful objects from JSON.
 */
public class YahooWeatherDataDeserializer implements JsonDeserializer<YahooWeatherData>
{
    @Override
    public YahooWeatherData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        String[] path = new String[]{
                "query",
                "results",
                "channel"
        };

        for(int i = 0; i < path.length; ++i)
        {
            if(!json.isJsonObject())
            {
                throw new JsonParseException("Cannot navigate to "
                        + path[i]
                        + " while parsing "
                        + YahooWeatherData.class.getSimpleName());
            }

            JsonObject object = json.getAsJsonObject();
            json = object.get(path[i]);
        }

        return new Gson().fromJson(json, YahooWeatherData.class);
    }
}
