package com.endava.weatherapp.api;

import android.content.Context;

import com.endava.weatherapp.Constants;
import com.endava.weatherapp.WeatherApp;
import com.endava.weatherapp.domain.WeatherByCityResponse;
import com.endava.weatherapp.temperature.WeatherEvent;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
public class WeatherService {

    @Inject
    WeatherEndpoint weatherEndpoint;
    @Inject
    Bus bus;

    public WeatherService(Context context) {
        ((WeatherApp) context.getApplicationContext()).getWeatherComponent().inject(this);
    }

    public void getWeatherByCityName(String city) {
        weatherEndpoint.getWeatherByCity(city, Constants.API_KEY, new Callback<WeatherByCityResponse>() {
            @Override
            public void success(WeatherByCityResponse weatherByCityResponse, Response response) {
                bus.post(new WeatherEvent(weatherByCityResponse));
            }

            @Override
            public void failure(RetrofitError error) {
                bus.post(new WeatherEvent(error));
            }
        });
    }
}
