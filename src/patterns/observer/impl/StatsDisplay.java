package patterns.observer.impl;

import patterns.observer.interfaces.Display;
import patterns.observer.interfaces.Observed;
import patterns.observer.interfaces.Observer;

public class StatsDisplay implements Observer, Display {
  int data;
  Observed weatherData;

  public StatsDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("StatsDisplay: "+data);
  }

  @Override
  public void update(int data) {
    this.data = data;
    this.display();
  }
}
