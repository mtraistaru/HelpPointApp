package com.endava.weatherapp.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
public class WeatherByCityResponse {

    @SerializedName("main")
    private MainWeatherParams mainWeatherParams;

    public MainWeatherParams getMainWeatherParams() {
        return mainWeatherParams;
    }

    public void setMainWeatherParams(MainWeatherParams mainWeatherParams) {
        this.mainWeatherParams = mainWeatherParams;
    }
}
