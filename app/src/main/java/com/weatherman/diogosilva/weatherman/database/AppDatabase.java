package com.weatherman.diogosilva.weatherman.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.weatherman.diogosilva.weatherman.database.DAO.CityDAO;
import com.weatherman.diogosilva.weatherman.database.entities.City;

/**
 * Created by diogosilva on 17/06/18.
 */

@Database(entities = {City.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract CityDAO cityDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "weatherman-database")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
