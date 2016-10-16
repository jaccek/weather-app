package com.github.jaccek.weatherapp.network.connectors;

import com.github.jaccek.weatherapp.network.ExceptionNetwork;
import com.github.jaccek.weatherapp.network.models.RawCity;

import java.util.List;

/**
 * Created by jacek on 10/9/16.
 */

public interface ConnectorChooseCity
{
    List<RawCity> downloadCities() throws ExceptionNetwork;
}
