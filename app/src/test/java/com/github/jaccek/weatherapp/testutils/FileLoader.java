package com.github.jaccek.weatherapp.testutils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jacek on 9/29/16.
 */

public class FileLoader
{
    public static String loadFile(String pFilename) throws Exception
    {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(pFilename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();
        String line = reader.readLine();
        while (line != null)
        {
            stringBuilder.append(line);
            line = reader.readLine();
        }

        return stringBuilder.toString();
    }
}
