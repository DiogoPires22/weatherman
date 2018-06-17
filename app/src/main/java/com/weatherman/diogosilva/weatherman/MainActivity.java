package com.weatherman.diogosilva.weatherman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.weatherman.diogosilva.weatherman.api.WeatherAPI;
import com.weatherman.diogosilva.weatherman.api.requests.WeatherRequest;
import com.weatherman.diogosilva.weatherman.api.results.WeatherResult;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherAPI.getInstance().weather().getWeather(3477)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherData -> {
                    Log.e("Current Weather", "ANAL");

                });
    }

}
