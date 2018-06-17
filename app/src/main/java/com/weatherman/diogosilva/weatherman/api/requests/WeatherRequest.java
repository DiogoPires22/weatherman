package com.weatherman.diogosilva.weatherman.api.requests;


import com.weatherman.diogosilva.weatherman.api.results.WeatherResult;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by diogosilva on 15/06/18.
 */

public interface WeatherRequest {
    @GET("weather/locale/{cittyId}/current")
    io.reactivex.Observable<WeatherResult> getWeather(@Path("cittyId") int cittyId);
}
