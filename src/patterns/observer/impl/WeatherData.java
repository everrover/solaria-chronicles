package patterns.observer.impl;

import patterns.observer.interfaces.Observed;
import patterns.observer.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Observed{

  List<Observer> observers;
  int data;

  public WeatherData(List<Observer> observers, int data) {
    this.observers = observers;
    this.data = data;
  }

  public WeatherData() {
    this(new ArrayList<>(), 0);
  }

  @Override
  public boolean registerObserver(Observer obs) {
    try{
      observers.add(obs);
      return true;
    }catch (Exception e) {
      return false;
    }
  }

  @Override
  public boolean unregisterObserver(Observer obs) {
    try{
      observers.remove(obs);
      return true;
    }catch (Exception e) {
      return false;
    }
  }

  @Override
  public boolean notifyObservers() {
    try{
      for(Observer obs: observers){ obs.update(this.data); }
      return true;
    }catch (Exception e) {
      return false;
    }
  }

  @Override
  public int getData() {
    return this.data;
  }

  @Override
  public void setData(int data) {
    this.data = data;
    this.notifyObservers();
  }
}
