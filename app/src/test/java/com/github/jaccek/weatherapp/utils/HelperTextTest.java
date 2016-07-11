package com.github.jaccek.weatherapp.utils;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link HelperText}
 */
public class HelperTextTest
{
    @Test
    public void isStringEmptyTestValidString() throws Exception
    {
        assertFalse(HelperText.isStringEmpty("test"));
    }

    @Test
    public void isStringEmptyTextNullString() throws Exception
    {
        assertTrue(HelperText.isStringEmpty(null));
    }

    @Test
    public void isStringEmptyTextEmptyString() throws Exception
    {
        assertTrue(HelperText.isStringEmpty(""));
    }
}