package com.endava.weatherapp.temperature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.endava.weatherapp.R;
import com.endava.weatherapp.WeatherApp;

import javax.inject.Inject;

/**
 * Created by Mihai.Traistaru on 03/30/2017.
 */

public class TemperatureActivity extends AppCompatActivity implements TemperatureContract.View {

    @Inject
    TemperatureContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TemperatureComponent temperatureComponent = ((WeatherApp) getApplication()).getTemperatureComponent(this);
        temperatureComponent.inject(this);
        setContentView(R.layout.activity_temperature);
        Button getData = (Button) findViewById(R.id.getDataButton);
        if (getData != null) {
            getData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.getDataClicked();
                }
            });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showKelvinTemperature(double kelvinTemperature) {
        TextView kelvinTemperatureTextView = (TextView) findViewById(R.id.kelvinTemperatureValue);
        if (kelvinTemperatureTextView != null) {
            kelvinTemperatureTextView.setText(String.valueOf(Math.round(kelvinTemperature)));
        }
    }

    @Override
    public void showCelsiusTemperature(double celsiusTemperature) {
        TextView celsiusTemperatureTextView = (TextView) findViewById(R.id.celsiusTemperatureValue);
        if (celsiusTemperatureTextView != null) {
            celsiusTemperatureTextView.setText(String.valueOf(Math.round(celsiusTemperature)));
        }
    }

    @Override
    public void showFahrenheitTemperature(double fahrenheitTemperature) {
        TextView fahrenheitTemperatureTextView = (TextView) findViewById(R.id.fahrenheitTemperatureValue);
        if (fahrenheitTemperatureTextView != null) {
            fahrenheitTemperatureTextView.setText(String.valueOf(Math.round(fahrenheitTemperature)));
        }
    }
}
