package com.github.jaccek.weatherapp.frameworks.view.choosecity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.jaccek.weatherapp.R;

/**
 * Activity for choosing city.
 */
public class ActivityCityChooser extends AppCompatActivity
{
    private final static int LAYOUT_ID = R.layout.activity_city_chooser;

    public static void startActivity(Activity pActivity)
    {
        Intent intent = new Intent(pActivity, ActivityCityChooser.class);
        pActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);
    }
}
