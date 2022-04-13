package patterns.observer.impl;

import patterns.observer.interfaces.Display;
import patterns.observer.interfaces.Observed;
import patterns.observer.interfaces.Observer;

public class ForecastDisplay implements Observer, Display {
  int data;
  Observed weatherData;

  public ForecastDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("ForecastDisplay: "+data);
  }

  @Override
  public void update(int data) {
    this.data = data;
    this.display();
  }
}
