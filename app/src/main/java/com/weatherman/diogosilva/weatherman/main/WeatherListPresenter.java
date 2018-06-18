package com.weatherman.diogosilva.weatherman.main;

import android.content.Context;
import android.util.Log;

import com.weatherman.diogosilva.weatherman.database.AppDatabase;
import com.weatherman.diogosilva.weatherman.database.DatabaseManager;
import com.weatherman.diogosilva.weatherman.database.entities.City;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by diogosilva on 17/06/18.
 */

public class WeatherListPresenter {

    private DatabaseManager mDatabaseManager;
    private Context mContext;

    WeatherListPresenter(Context context){
        mDatabaseManager = new DatabaseManager(context);
    }

    public void getCities(){
        AppDatabase.getAppDatabase(mContext).cityDAO().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<City>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<City> cities) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
