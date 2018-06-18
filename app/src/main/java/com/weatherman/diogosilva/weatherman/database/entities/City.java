package com.weatherman.diogosilva.weatherman.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.provider.BaseColumns;
import android.content.ContentValues;
import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by diogosilva on 17/06/18.
 */


@Entity(tableName = City.TABLE_NAME)
public class City {

    /** The name of the Cheese table. */
    public static final String TABLE_NAME = "cities";

    /** The name of the ID column. */
    public static final String COLUMN_ID = BaseColumns._ID;

    /** The name of the name column. */
    public static final String COLUMN_NAME = "name";

    /** The name of the serverId column. */
    public static final String COLUMN_SERVER_ID = "server_id";

    /** The name of the state column. */
    public static final String COLUMN_STATE = "state";

    /** The name of the state column. */
    public static final String COLUMN_LAST_DATE = "last_date";

    /** The name of the last weather column. */
    public static final String COLUMN_LAST_WEATHER = "last_weather";


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    public long id;

    @ColumnInfo(name = COLUMN_SERVER_ID)
    public int serverId;

    @ColumnInfo(name = COLUMN_NAME)
    public String name;

    @ColumnInfo(name = COLUMN_STATE)
    public String state;

    @ColumnInfo(name = COLUMN_LAST_DATE)
    public String lastDate;


    @ColumnInfo(name = COLUMN_LAST_WEATHER)
    public int lastWeather;




}
