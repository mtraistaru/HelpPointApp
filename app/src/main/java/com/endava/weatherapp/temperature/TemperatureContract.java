package com.endava.weatherapp.temperature;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */

public interface TemperatureContract {

    interface Model {

        void setCallback(TemperatureModel.Callback callback);

        void setup();

        void tearDown();

        void requestWeather();
    }

    interface View {

        void showKelvinTemperature(double kelvinTemperature);

        void showCelsiusTemperature(double celsiusTemperature);

        void showFahrenheitTemperature(double fahrenheitTemperature);
    }

    interface Presenter {

        void getDataClicked();

        void onResume();

        void onPause();
    }
}
