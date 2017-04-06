package com.endava.weatherapp.temperature;

import com.endava.weatherapp.api.WeatherService;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */

class TemperatureModel implements TemperatureContract.Model {

    private WeatherService weatherService;
    private Bus bus;

    TemperatureModel(WeatherService weatherService, Bus bus) {
        this.weatherService = weatherService;
        this.bus = bus;
    }

    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void setup() {
        bus.register(this);
    }

    @Override
    public void tearDown() {
        bus.unregister(this);
    }

    @Override
    public void requestWeather() {
        weatherService.getWeatherByCityName("Cluj");
    }

    @Subscribe
    public void onWeatherEvent(WeatherEvent weatherEvent) {
        callback.onWeatherEvent(weatherEvent);
    }

    interface Callback {
        void onWeatherEvent(WeatherEvent weatherEvent);
    }
}
