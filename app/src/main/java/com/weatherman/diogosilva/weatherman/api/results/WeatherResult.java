package com.weatherman.diogosilva.weatherman.api.results;

import java.util.Date;
import java.util.List;

/**
 * Created by diogosilva on 15/06/18.
 */

public class WeatherResult {
    private int id;
    private String name;
    private String state;
    private String country;

    private Data data;


    public class Data{

        private float temperature;
        private String windDirection;
        private String windVelocity;
        private float humidity;
        private String condition;
        private String pressure;
        private String icon;
        private String sensation;
        private String date;

    }

}


