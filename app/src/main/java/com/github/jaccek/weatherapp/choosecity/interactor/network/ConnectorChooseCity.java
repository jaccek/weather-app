package com.github.jaccek.weatherapp.choosecity.interactor.network;

import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.data.RawCity;

import java.util.List;

/**
 * Created by jacek on 10/9/16.
 */

public interface ConnectorChooseCity
{
    List<RawCity> downloadCities() throws ExceptionNetwork;
}
