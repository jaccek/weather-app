package com.github.jaccek.weatherapp.utils;

import java.text.Normalizer;

/**
 * Created by jacek on 10/8/16.
 */
public class StringHelper
{
    private StringHelper()
    {
    }

    public static String normalize(String pString)
    {
        String normalized = Normalizer.normalize(pString, Normalizer.Form.NFC);
        return normalized.toLowerCase()
                .replaceAll("ą", "a")
                .replaceAll("ć", "c")
                .replaceAll("ę", "e")
                .replaceAll("ł", "l")
                .replaceAll("ń", "n")
                .replaceAll("ó", "o")
                .replaceAll("ś", "s")
                .replaceAll("ż", "z")
                .replaceAll("ź", "z");
    }
}
