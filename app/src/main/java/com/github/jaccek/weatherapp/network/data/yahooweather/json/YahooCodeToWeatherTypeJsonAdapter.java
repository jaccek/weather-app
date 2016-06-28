package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Converter from Yahoo Weather code to {@link IWeatherData.WeatherType}.
 * <p/>
 * 0	tornado
 * 1	tropical storm
 * 2	hurricane
 * 3	severe thunderstorms
 * 4	thunderstorms
 * 5	mixed rain and snow
 * 6	mixed rain and sleet
 * 7	mixed snow and sleet
 * 8	freezing drizzle
 * 9	drizzle
 * 10	freezing rain
 * 11	showers
 * 12	showers
 * 13	snow flurries
 * 14	light snow showers
 * 15	blowing snow
 * 16	snow
 * 17	hail
 * 18	sleet
 * 19	dust
 * 20	foggy
 * 21	haze
 * 22	smoky
 * 23	blustery
 * 24	windy
 * 25	cold
 * 26	cloudy
 * 27	mostly cloudy (night)
 * 28	mostly cloudy (day)
 * 29	partly cloudy (night)
 * 30	partly cloudy (day)
 * 31	clear (night)
 * 32	sunny
 * 33	fair (night)
 * 34	fair (day)
 * 35	mixed rain and hail
 * 36	hot
 * 37	isolated thunderstorms
 * 38	scattered thunderstorms
 * 39	scattered thunderstorms
 * 40	scattered showers
 * 41	heavy snow
 * 42	scattered snow showers
 * 43	heavy snow
 * 44	partly cloudy
 * 45	thundershowers
 * 46	snow showers
 * 47	isolated thundershowers
 */
public class YahooCodeToWeatherTypeJsonAdapter extends TypeAdapter<IWeatherData.WeatherType>
{
    @Override
    public void write(JsonWriter out, IWeatherData.WeatherType value) throws IOException
    {
        // not used
    }

    @Override
    public IWeatherData.WeatherType read(JsonReader in) throws IOException
    {
        int type = -1;
        switch(in.peek())
        {
            case STRING:
                type = Integer.parseInt(in.nextString());
                break;

            case NUMBER:
                type = in.nextInt();
                break;

            default:
                throw new IOException("Bad token type");
        }

        switch(type)
        {
            case 31:    // clear (night)
            case 32:    // sunny
            case 33:    // fair (night)
            case 34:    // fair (day)
            case 36:    // hot
                return IWeatherData.WeatherType.SUNNY;

            case 23:    // blustery
            case 24:    // windy
            case 25:    // cold
            case 26:    // cloudy
            case 29:    // partly cloudy (night)
            case 30:    // partly cloudy (day)
            case 44:    // partly cloudy
                return IWeatherData.WeatherType.CLOUDY;

            case 27:    // mostly cloudy (night)
            case 28:    // mostly cloudy (day):
                return IWeatherData.WeatherType.MOSTLY_CLOUDY;

            case 19:    // dust
            case 20:    // foggy
            case 21:    // haze
            case 22:    // smoky
                return IWeatherData.WeatherType.FOGGY;

            case 5:     // mixed rain and snow
            case 6:     // mixed rain and sleet
            case 8:     // freezing drizzle
            case 9:     // drizzle
            case 10:    // freezing rain
            case 11:    // showers
            case 12:    // showers
            case 17:    // hail
            case 18:    // sleet
            case 35:    // mixed rain and hail
            case 40:    // scattered showers
                return IWeatherData.WeatherType.RAINY;

            case 0:     // tornado
            case 1:     // tropical storm
            case 2:     // hurricane
            case 3:     // severe thunderstorms
            case 4:     // thunderstorms
            case 37:    // isolated thunderstorms
            case 38:    // scattered thunderstorms
            case 39:    // scattered thunderstorms
            case 45:    // thundershowers
            case 47:    // isolated thundershowers
                return IWeatherData.WeatherType.STORM;

            case 7:     // mixed snow and sleet
            case 13:    // snow flurries
            case 14:    // light snow showers
            case 15:    // blowing snow
            case 16:    // snow
            case 41:    // heavy snow
            case 42:    // scattered snow showers
            case 43:    // heavy snow
            case 46:    // snow showers
                return IWeatherData.WeatherType.SNOW;

            default:
                return IWeatherData.WeatherType.UNKNOWN;
        }
    }
}
