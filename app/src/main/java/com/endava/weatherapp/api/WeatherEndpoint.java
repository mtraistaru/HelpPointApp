package com.endava.weatherapp.api;

import com.endava.weatherapp.domain.WeatherByCityResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
public interface WeatherEndpoint {

    @GET("/weather")
    void getWeatherByCity(@Query("q") String city, @Query("APPID") String apiKey, Callback<WeatherByCityResponse> response);
}
