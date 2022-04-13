package patterns.observer;

import patterns.observer.builtin.*;
import patterns.observer.impl.*;
import patterns.observer.interfaces.Display;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Display forecast = new ForecastDisplay(weatherData);
        Display stats = new StatsDisplay(weatherData);
        Display curr = new CurrentConditionsDisplay(weatherData);

        weatherData.setData(24);
        weatherData.setData(82);
        weatherData.setData(56);

        // Using java.util `Observer` and `Observable`
        OWeatherData weatherData1 = new OWeatherData("Lovely isn't it!!");
        OStattsDisplay statsDisplay = new OStattsDisplay(weatherData1);
        OForecastDisplay forecastDisplay = new OForecastDisplay(weatherData1);

        weatherData1.setWeather("Lovely isn't it!!11");
        weatherData1.setWeather("Lovely isn't it!!22");
        weatherData1.setWeather("Lovely isn't it!!33");

        // Using `PropertyChangeListener` and `PropertyChangeSupport`
        PCLWeatherData weatherData2=  new PCLWeatherData("Horrible isn't it!!");
        PCLStattsDisplay stattsDisplay = new PCLStattsDisplay();
        weatherData2.addPropertyChangeListener(stattsDisplay);
        weatherData2.setWeather("Horrible isn't it!!11");
        weatherData2.setWeather("Horrible isn't it!!22");
    }
}
