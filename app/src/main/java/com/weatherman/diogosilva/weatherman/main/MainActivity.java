package com.weatherman.diogosilva.weatherman.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.weatherman.diogosilva.weatherman.R;
import com.weatherman.diogosilva.weatherman.database.AppDatabase;
import com.weatherman.diogosilva.weatherman.database.entities.City;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        WeatherAPI.getInstance().weather().getWeather(3477)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(weatherData -> {
//                    Log.e("Current Weather", "ANAL");
//
//                });

//        WeathermanProvider provider = new WeathermanProvider();
//
//        City c = new City();
//        c.lastWeather =1;
//        c.state = "SP";
//        c.name = "São Paulo";
//        c.serverId = 3477;

//        Log.d("wft",AppDatabase.getAppDatabase(getApplicationContext()).cityDAO().insert(c)+"");
//
//
//
//
//                /*
//
//
//                 */


    }

}
