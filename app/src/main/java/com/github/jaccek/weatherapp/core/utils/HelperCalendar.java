package com.github.jaccek.weatherapp.core.utils;

import java.util.Calendar;

/**
 * Created by jacek on 8/10/16.
 */
public class HelperCalendar
{
    private HelperCalendar()
    {
    }

    public static boolean areDaysTheSame(Calendar pDate1, Calendar pDate2)
    {
        if (pDate1 == null || pDate2 == null)
        {
            return false;
        }

        return pDate1.get(Calendar.YEAR) == pDate2.get(Calendar.YEAR)
                && pDate1.get(Calendar.DAY_OF_YEAR) == pDate2.get(Calendar.DAY_OF_YEAR);
    }
}
