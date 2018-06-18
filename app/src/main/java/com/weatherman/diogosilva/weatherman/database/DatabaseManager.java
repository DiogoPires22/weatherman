package com.weatherman.diogosilva.weatherman.database;

import android.content.Context;

import com.weatherman.diogosilva.weatherman.database.entities.City;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by diogosilva on 17/06/18.
 */

public class DatabaseManager {

    private static DatabaseManager INSTANCE;
    private AppDatabase db;

    public static DatabaseManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager(context);
        }
        return INSTANCE;
    }

    public DatabaseManager(Context context) {
        db = AppDatabase.getAppDatabase(context);
    }


    public Single<List<City>> getAll(){
        return db.cityDAO().getAll();
    }

}
