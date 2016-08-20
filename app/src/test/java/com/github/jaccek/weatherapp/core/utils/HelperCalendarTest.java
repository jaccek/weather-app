package com.github.jaccek.weatherapp.core.utils;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jacek on 8/10/16.
 */
public class HelperCalendarTest
{
    @Test(expected = IllegalAccessException.class)
    public void isConstructorPrivateTest() throws Exception
    {
        Constructor<HelperCalendar> constructor = HelperCalendar.class.getDeclaredConstructor();
        constructor.newInstance();
    }

    @Test
    public void areDaysTheSameTestSameDays()
    {
        Calendar firstDay = Calendar.getInstance();
        firstDay.set(Calendar.DAY_OF_YEAR, 2);
        firstDay.set(Calendar.HOUR, 1);

        Calendar secondDay = Calendar.getInstance();
        secondDay.set(Calendar.DAY_OF_YEAR, 2);
        secondDay.set(Calendar.HOUR, 4);

        assertTrue(HelperCalendar.areDaysTheSame(firstDay, secondDay));
    }

    @Test
    public void areDaysTheSameTestDifferentDays()
    {
        Calendar firstDay = Calendar.getInstance();
        firstDay.set(Calendar.DAY_OF_YEAR, 2);

        Calendar secondDay = Calendar.getInstance();
        secondDay.set(Calendar.DAY_OF_YEAR, 123);

        assertFalse(HelperCalendar.areDaysTheSame(firstDay, secondDay));
    }

    @Test
    public void areDaysTheSameTestNullDay()
    {
        Calendar firstDay = Calendar.getInstance();
        firstDay.set(Calendar.DAY_OF_YEAR, 2);

        assertFalse(HelperCalendar.areDaysTheSame(firstDay, null));
    }
}