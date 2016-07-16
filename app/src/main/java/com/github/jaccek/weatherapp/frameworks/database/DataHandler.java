package com.github.jaccek.weatherapp.frameworks.database;

/**
 * Data handler used to receive data from {@link ManagerData}
 */
public interface DataHandler<T>
{
    void onData(T pData);

    void onError();
}
