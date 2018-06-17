package com.weatherman.diogosilva.weatherman.api;

import com.weatherman.diogosilva.weatherman.api.requests.WeatherRequest;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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



    public static WeatherAPI getInstance(){
        if (instance == null){
            instance = new WeatherAPI();
        }
        return instance;
    }

    private WeatherAPI(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient =  new OkHttpClient.Builder();
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder()
                        .addQueryParameter(ServerConstants.TOKEN_PARAM,ServerConstants.API_KEY).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });
        httpClient.addInterceptor(logging);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ServerConstants.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }


    public WeatherRequest weather(){
        return mRetrofit.create(WeatherRequest.class);
    }
}
