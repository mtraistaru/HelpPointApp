package com.endava.weatherapp.temperature;

import com.endava.weatherapp.PageScope;
import com.endava.weatherapp.WeatherComponent;

import dagger.Component;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */
@PageScope
@Component(dependencies = WeatherComponent.class, modules = TemperatureModule.class)
public interface TemperatureComponent {

    void inject(TemperatureActivity temperatureActivity);
}
