package com.endava.weatherapp;

import com.endava.weatherapp.temperature.TemperatureComponent;
import com.endava.weatherapp.temperature.TemperatureContract;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */

public interface WeatherApp {

    WeatherComponent getWeatherComponent();

    TemperatureComponent getTemperatureComponent(TemperatureContract.View view);
}
