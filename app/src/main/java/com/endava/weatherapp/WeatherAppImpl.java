package com.endava.weatherapp;

import android.app.Application;

import com.endava.weatherapp.module.CommonModule;
import com.endava.weatherapp.module.WebserviceModule;
import com.endava.weatherapp.temperature.DaggerTemperatureComponent;
import com.endava.weatherapp.temperature.TemperatureComponent;
import com.endava.weatherapp.temperature.TemperatureContract;
import com.endava.weatherapp.temperature.TemperatureModule;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
public class WeatherAppImpl extends Application implements WeatherApp {

    WeatherComponent weatherComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        weatherComponent = DaggerWeatherComponent
                .builder()
                .commonModule(new CommonModule(this))
                .webserviceModule(new WebserviceModule())
                .build();
    }

    @Override
    public WeatherComponent getWeatherComponent() {
        return weatherComponent;
    }

    @Override
    public TemperatureComponent getTemperatureComponent(TemperatureContract.View view) {
        return DaggerTemperatureComponent.builder()
                .weatherComponent(weatherComponent)
                .temperatureModule(new TemperatureModule(view))
                .build();
    }
}
