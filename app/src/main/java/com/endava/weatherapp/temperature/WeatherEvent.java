package com.endava.weatherapp.temperature;

import com.endava.weatherapp.domain.WeatherByCityResponse;
import retrofit.RetrofitError;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
public class WeatherEvent {

    private WeatherByCityResponse weatherByCityResponse;
    private RetrofitError retrofitError;

    public WeatherEvent(WeatherByCityResponse weatherByCityResponse) {
        this.weatherByCityResponse = weatherByCityResponse;
    }

    public WeatherEvent(RetrofitError retrofitError) {
        this.retrofitError = retrofitError;
    }

    public WeatherByCityResponse getWeatherByCityResponse() {
        return weatherByCityResponse;
    }

    public void setWeatherByCityResponse(WeatherByCityResponse weatherByCityResponse) {
        this.weatherByCityResponse = weatherByCityResponse;
    }

    public RetrofitError getRetrofitError() {
        return retrofitError;
    }

    public void setRetrofitError(RetrofitError retrofitError) {
        this.retrofitError = retrofitError;
    }
}
