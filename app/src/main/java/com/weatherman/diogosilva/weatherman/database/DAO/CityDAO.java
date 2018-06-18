package com.weatherman.diogosilva.weatherman.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.weatherman.diogosilva.weatherman.database.entities.City;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by diogosilva on 17/06/18.
 */

@Dao
public interface CityDAO {
    @Query("SELECT * FROM "+ City.TABLE_NAME)
    Single<List<City>> getAll();

    @Query("SELECT * FROM "+ City.TABLE_NAME+" where "+ City.COLUMN_NAME+" LIKE :name LIMIT 1")
    Single<City> findByName(String name);

    @Query("SELECT * FROM  "+ City.TABLE_NAME+" where "+ City.COLUMN_SERVER_ID+" = :serverId LIMIT 1")
    Single<City> findById(long serverId);

    /**
     * Inserts a city into the table.
     *
     * @param city A new city.
     * @return The row ID of the newly inserted city.
     */
    @Insert
    long insert(City city);


    /**
     * Inserts multiple cities into the database
     *
     * @param cities An array of new cheeses.
     * @return The row IDs of the newly inserted cheeses.
     */
    @Insert
    long[] insertAll(City[] cities);


    /**
     * Delete a city by the ID.
     *
     * @param id The row ID.
     * @return A number of cities deleted. This should always be {@code 1}.
     */
    @Query("DELETE FROM " + City.TABLE_NAME + " WHERE " + City.COLUMN_ID + " = :id")
    int deleteById(long id);

    /**
     * Delete a city by the NAME.
     *
     * @param name The row NAME.
     * @return A number of cities deleted. This should always be {@code 1}.
     */
    @Query("DELETE FROM " + City.TABLE_NAME + " WHERE " + City.COLUMN_NAME + " = :name")
    int deleteByName(String name);

    /**
     * Update the city. The city is identified by the row ID.
     *
     * @param city The city to update.
     * @return A number of cities updated. This should always be {@code 1}.
     */
    @Update
    int update(City city);
}
