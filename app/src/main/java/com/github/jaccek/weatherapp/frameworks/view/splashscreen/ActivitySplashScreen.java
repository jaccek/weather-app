package com.github.jaccek.weatherapp.frameworks.view.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.jaccek.weatherapp.frameworks.view.actualweather.ActivityActualWeather;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash_screen);

        Intent intent = new Intent(this, ActivityActualWeather.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }
}
