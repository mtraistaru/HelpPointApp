package com.endava.weatherapp.module;

import android.content.Context;

import com.endava.weatherapp.Constants;
import com.endava.weatherapp.api.WeatherEndpoint;
import com.endava.weatherapp.api.WeatherService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
@Module
public class WebserviceModule {

    @Singleton
    @Provides
    WeatherEndpoint provideWeatherEndpoint(RestAdapter restAdapter) {
        return restAdapter.create(WeatherEndpoint.class);
    }

    @Singleton
    @Provides
    RestAdapter provideWeatherRestAdapter(OkClient client, RequestInterceptor requestInterceptor, Gson gson) {
        return new RestAdapter.Builder()
                .setClient(client)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(Constants.ENDPOINT)
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new GsonConverter(gson))
                .build();
    }

    @Singleton
    @Provides
    WeatherService provideWeatherService(Context context) {
        return new WeatherService(context);
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    OkClient provideClient() {
        return new OkClient(new OkHttpClient());
    }

    @Singleton
    @Provides
    RequestInterceptor provideRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
                request.addHeader("Content-Type", "application/json");
            }
        };
    }
}