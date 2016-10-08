package com.github.jaccek.weatherapp.choosecity.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.jaccek.weatherapp.R;
import com.github.jaccek.weatherapp.choosecity.ContractChooseCity;
import com.github.jaccek.weatherapp.data.City;

import java.util.List;

/**
 * Created by jacek on 10/3/16.
 */

public class ActivityChooseCity extends AppCompatActivity implements
        ContractChooseCity.View,
        ContractChooseCity.Router
{
    public static final String SELECTED_CITY_ID = "SELECTED_CITY_ID";

    private static final int LAYOUT_ID = R.layout.activity_city_chooser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);
    }

    public static void startActivityForResult(Activity pActivity, City pSelectedCity, int pRequestCode)
    {
        Intent intent = new Intent(pActivity, ActivityChooseCity.class);
        intent.putExtra(SELECTED_CITY_ID, pSelectedCity.getId());
        pActivity.startActivityForResult(intent, pRequestCode);
    }

    @Override
    public void backToActualWeather(@Nullable City pSelectedCity)
    {

    }

    @Override
    public void showLoader()
    {

    }

    @Override
    public void showCities(List<City> pCities)
    {

    }

    @Override
    public void showSearcher()
    {

    }

    @Override
    public void showError()
    {

    }
}
