package com.github.jaccek.weatherapp.network.data.yahooweather.json;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.google.gson.stream.JsonReader;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jacek on 6/26/16.
 */
public class YahooCodeToWeatherTypeJsonAdapterTest
{
    @Test
    public void testReadSunny() throws Exception
    {
//    31	clear (night)
//    32	sunny
//    33	fair (night)
//    34	fair (day)
//    36	hot
        String[] jsons = new String[] {
                "[\"31\"]",
                "[\"32\"]",
                "[\"33\"]",
                "[\"34\"]",
                "[36]",
        };

        testRead(jsons, IWeatherData.WeatherType.SUNNY);
    }

    @Test
    public void testReadCloudy() throws Exception
    {
//    23	blustery
//    24	windy
//    25	cold
//    26	cloudy
//    29	partly cloudy (night)
//    30	partly cloudy (day)
//    44	partly cloudy
        String[] jsons = new String[] {
                "[\"23\"]",
                "[\"24\"]",
                "[\"25\"]",
                "[\"26\"]",
                "[\"29\"]",
                "[\"30\"]",
                "[44]",
        };

        testRead(jsons, IWeatherData.WeatherType.CLOUDY);
    }

    @Test
    public void testReadMostlyCloudy() throws Exception
    {
//    27	mostly cloudy (night)
//    28	mostly cloudy (day)
        String[] jsons = new String[] {
                "[\"27\"]",
                "[28]",
        };

        testRead(jsons, IWeatherData.WeatherType.MOSTLY_CLOUDY);
    }

    @Test
    public void testReadFoggy() throws Exception
    {
//    19	dust
//    20	foggy
//    21	haze
//    22	smoky
        String[] jsons = new String[] {
                "[\"19\"]",
                "[\"20\"]",
                "[\"21\"]",
                "[22]",
        };

        testRead(jsons, IWeatherData.WeatherType.FOGGY);
    }

    @Test
    public void testReadRainy() throws Exception
    {
//    5	mixed rain and snow
//    6	mixed rain and sleet
//    8	freezing drizzle
//    9	drizzle
//    10	freezing rain
//    11	showers
//    12	showers
//    17	hail
//    18	sleet
//    35	mixed rain and hail
//    40	scattered showers
        String[] jsons = new String[] {
                "[\"5\"]",
                "[\"6\"]",
                "[\"8\"]",
                "[\"9\"]",
                "[\"10\"]",
                "[\"11\"]",
                "[\"12\"]",
                "[\"17\"]",
                "[\"18\"]",
                "[\"35\"]",
                "[40]",
        };

        testRead(jsons, IWeatherData.WeatherType.RAINY);
    }

    @Test
    public void testReadStorm() throws Exception
    {
//    0	tornado
//    1	tropical storm
//    2	hurricane
//    3	severe thunderstorms
//    4	thunderstorms
//    37	isolated thunderstorms
//    38	scattered thunderstorms
//    39	scattered thunderstorms
//    45	thundershowers
//    47	isolated thundershowers
        String[] jsons = new String[] {
                "[\"0\"]",
                "[\"1\"]",
                "[\"2\"]",
                "[\"3\"]",
                "[\"4\"]",
                "[\"37\"]",
                "[\"38\"]",
                "[\"39\"]",
                "[\"45\"]",
                "[47]",
        };

        testRead(jsons, IWeatherData.WeatherType.STORM);
    }

    @Test
    public void testReadSnow() throws Exception
    {
//    7	mixed snow and sleet
//    13	snow flurries
//    14	light snow showers
//    15	blowing snow
//    16	snow
//    41	heavy snow
//    42	scattered snow showers
//    43	heavy snow
//    46	snow showers
        String[] jsons = new String[] {
                "[\"7\"]",
                "[\"13\"]",
                "[\"14\"]",
                "[\"15\"]",
                "[\"16\"]",
                "[\"41\"]",
                "[\"42\"]",
                "[\"43\"]",
                "[46]",
        };

        testRead(jsons, IWeatherData.WeatherType.SNOW);
    }

    @Test
    public void testReadUnknown() throws Exception
    {
        String[] jsons = new String[] {
                "[\"48\"]",
                "[\"123\"]",
                "[67]",
        };

        testRead(jsons, IWeatherData.WeatherType.UNKNOWN);
    }

    private void testRead(String[] pJsons, IWeatherData.WeatherType pExpectedWeatherType) throws IOException
    {
        YahooCodeToWeatherTypeJsonAdapter adapter = new YahooCodeToWeatherTypeJsonAdapter();

        for(String json : pJsons)
        {
            JsonReader reader = new JsonReader(new StringReader(json));
            reader.beginArray();

            IWeatherData.WeatherType weatherType = adapter.read(reader);
            assertEquals(pExpectedWeatherType, weatherType);
        }
    }
}