package com.github.jaccek.weatherapp;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by jacek on 9/26/16.
 */

public class MockTestRunner extends AndroidJUnitRunner
{
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        return super.newApplication(cl, ApplicationWeatherMock.class.getName(), context);
    }
}
