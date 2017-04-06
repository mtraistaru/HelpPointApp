package com.endava.weatherapp;

import com.endava.weatherapp.domain.MainWeatherParams;
import com.endava.weatherapp.domain.WeatherByCityResponse;
import com.endava.weatherapp.temperature.TemperatureContract;
import com.endava.weatherapp.temperature.TemperaturePresenter;
import com.endava.weatherapp.temperature.WeatherEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Mihai.Traistaru on 03/29/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class TemperatureTest {

    private static final double KELVIN_TEMPERATURE = 280.0;
    private static final double KELVIN_TO_CELSIUS_OFFSET = 273.15;

    @Mock
    TemperatureContract.View view;

    @Mock
    TemperatureContract.Model model;

    private TemperaturePresenter presenter;

    @Before
    public void setup() {
        presenter = new TemperaturePresenter(view, model);
    }

    @Test
    public void testOnWeatherEvent() {
        WeatherEvent weatherEvent = Mockito.mock(WeatherEvent.class);
        WeatherByCityResponse weatherByCityResponse = Mockito.mock(WeatherByCityResponse.class);
        MainWeatherParams mainWeatherParams = Mockito.mock(MainWeatherParams.class);
        when(weatherEvent.getWeatherByCityResponse()).thenReturn(weatherByCityResponse);
        when(weatherByCityResponse.getMainWeatherParams()).thenReturn(mainWeatherParams);
        when(mainWeatherParams.getTemp()).thenReturn(KELVIN_TEMPERATURE);

        presenter.onWeatherEvent(weatherEvent);
        verify(view, times(1)).showKelvinTemperature(KELVIN_TEMPERATURE);
        verify(view, times(1)).showCelsiusTemperature(KELVIN_TEMPERATURE - KELVIN_TO_CELSIUS_OFFSET);
        verify(view, times(1)).showFahrenheitTemperature(KELVIN_TEMPERATURE * 9/5 - 459.67);
    }

    @Test
    public void testGetDataClicked() {
        presenter.getDataClicked();
        verify(model, times(1)).requestWeather();
    }

    @Test
    public void testOnResume() {
        presenter.onResume();
        verify(model, times(1)).setup();
    }

    @Test
    public void testOnPause() {
        presenter.onPause();
        verify(model, times(1)).tearDown();
    }
}