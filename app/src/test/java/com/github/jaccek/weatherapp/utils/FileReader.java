package com.github.jaccek.weatherapp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.net.URL;

/**
 * Reads files for tests.
 */
public class FileReader
{
    public static String loadFile(String pFilename) throws Exception
    {
        URL fileUrl = ClassLoader.getSystemResource(pFilename);
        File file = new File(fileUrl.getFile());
        java.io.FileReader reader = new java.io.FileReader(file);

        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();

        while (line != null)
        {
            sb.append(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return sb.toString();
    }
}
