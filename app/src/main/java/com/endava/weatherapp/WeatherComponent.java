package com.endava.weatherapp;

import com.endava.weatherapp.api.WeatherService;
import com.endava.weatherapp.module.CommonModule;
import com.endava.weatherapp.module.WebserviceModule;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
@Singleton
@Component(modules = {CommonModule.class, WebserviceModule.class})
public interface WeatherComponent {

    WeatherService getWeatherService();

    Bus getBus();

    void inject(WeatherService weatherService);
}
