package com.weatherman.diogosilva.weatherman.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diogosilva on 15/06/18.
 */

public class WeatherAPI {
    private static WeatherAPI instance;
    private Retrofit mRetrofit;

    public WeatherAPI getInstance(){
        if (instance == null){
            instance = new WeatherAPI();
        }
        return instance;
    }

    private WeatherAPI(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient =  new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ServerConstants.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
