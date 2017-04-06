package com.endava.weatherapp.temperature;

import com.endava.weatherapp.PageScope;
import com.endava.weatherapp.api.WeatherService;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */
@Module
@PageScope
public class TemperatureModule {

    private TemperatureContract.View view;

    public TemperatureModule(TemperatureContract.View view) {
        this.view = view;
    }

    @Provides
    @PageScope
    TemperatureContract.Presenter provideTemperaturePresenter(TemperatureContract.Model model) {
        return new TemperaturePresenter(view, model);
    }

    @Provides
    @PageScope
    TemperatureContract.Model provideTemperatureModel(WeatherService weatherService, Bus bus) {
        return new TemperatureModel(weatherService, bus);
    }
}
