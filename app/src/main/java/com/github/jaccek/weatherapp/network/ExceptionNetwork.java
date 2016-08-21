package com.github.jaccek.weatherapp.network;

/**
 * Created by jacek on 8/20/16.
 */
public class ExceptionNetwork extends Exception
{
    public ExceptionNetwork(Throwable throwable)
    {
        super(throwable);
    }

    public ExceptionNetwork(int pHttpResponseCode)
    {
        super("Http response code:" + pHttpResponseCode);
    }

    public ExceptionNetwork(String pMessage)
    {
        super(pMessage);
    }
}
