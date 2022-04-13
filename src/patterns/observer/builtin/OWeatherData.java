package patterns.observer.builtin;

import java.util.Observable;

public class OWeatherData extends Observable {
  private String weather;

  public OWeatherData(String weather) {
    this.weather = weather;
  }

  public void setWeather(String weather){
    this.weather = weather;
    setChanged();
    notifyObservers(this.weather);
  }
}
