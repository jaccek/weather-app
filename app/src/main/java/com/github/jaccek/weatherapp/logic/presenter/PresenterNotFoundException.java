package com.github.jaccek.weatherapp.logic.presenter;

/**
 * Created by jacek on 8/6/16.
 */
public class PresenterNotFoundException extends RuntimeException
{
    public PresenterNotFoundException(String detailMessage)
    {
        super(detailMessage);
    }
}
