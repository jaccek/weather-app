package com.github.jaccek.weatherapp.network.data.validator;

import com.github.jaccek.weatherapp.network.data.IWeatherData;
import com.github.jaccek.weatherapp.network.data.yahooweather.YahooWeatherData;
import com.github.jaccek.weatherapp.network.data.yahooweather.json.YahooWeatherDataDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static junit.framework.TestCase.assertEquals;

/**
 * Test for {@link WeatherDataValidator}
 */
public class WeatherDataValidatorTest
{
    @Test
    public void testIsValid() throws Exception
    {
        testFile("validator/YahooWeatherData_correct.json", true);
        testFile("validator/YahooWeatherData_wrongWind.json", false);
        testFile("validator/YahooWeatherData_wrongSunset.json", false);
        testFile("validator/YahooWeatherData_wrongSunrise.json", false);
        testFile("validator/YahooWeatherData_wrongTemperature.json", false);
    }

    private void testFile(String pFilename, boolean pIsCorrect) throws Exception
    {
        // get file as reader
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream(pFilename);
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(pFilename);
//        InputStream in = getClass().getResourceAsStream(pFilename);
        InputStreamReader reader = new InputStreamReader(in);

//        String json = com.github.jaccek.weatherapp.utils.FileReader.loadFile(pFilename);

        // parse data
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(YahooWeatherData.class, new YahooWeatherDataDeserializer())
                .create();
        IWeatherData data = gson.fromJson(reader, YahooWeatherData.class);

        assertEquals(pIsCorrect, new WeatherDataValidator().isValid(data));
    }
}