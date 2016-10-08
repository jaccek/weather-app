package com.github.jaccek.weatherapp.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacek on 10/8/16.
 */
public class StringHelperTest
{
    @Test
    public void testCapitalLetters()
    {
        String normalized = StringHelper.normalize("aBCdEfgH");
        assertEquals("abcdefgh", normalized);
    }

    @Test
    public void testPolishLetters()
    {
        String normalized = StringHelper.normalize("ąĄćĆęĘłŁńŃóÓśŚżŻźŹ");
        assertEquals("aacceellnnoosszzzz", normalized);
    }
}