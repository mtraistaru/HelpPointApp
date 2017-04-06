package com.endava.weatherapp.temperature;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */

public class TemperaturePresenter implements TemperatureContract.Presenter, TemperatureModel.Callback {

    private TemperatureContract.View view;
    private TemperatureContract.Model model;

    public TemperaturePresenter(TemperatureContract.View view, TemperatureContract.Model model) {
        this.view = view;
        this.model = model;
        model.setCallback(this);
    }

    @Override
    public void onWeatherEvent(WeatherEvent weatherEvent) {
        if (weatherEvent != null && weatherEvent.getWeatherByCityResponse() != null) {
            double kelvinTemperature = weatherEvent.getWeatherByCityResponse().getMainWeatherParams().getTemp();
            view.showKelvinTemperature(kelvinTemperature);
            view.showCelsiusTemperature(kelvinTemperature - 273.15);
            view.showFahrenheitTemperature(kelvinTemperature * 9 / 5 - 459.67);
        }
    }

    @Override
    public void getDataClicked() {
        model.requestWeather();
    }

    @Override
    public void onResume() {
        model.setup();
    }

    @Override
    public void onPause() {
        model.tearDown();
    }
}
