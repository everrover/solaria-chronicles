package patterns.observer.builtin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCLWeatherData {
  private String weather;

  private PropertyChangeSupport support;

  public PCLWeatherData(String weather) {
    this.weather = weather;
    support = new PropertyChangeSupport(this);
  }

  public void addPropertyChangeListener(PropertyChangeListener pcl){
    support.addPropertyChangeListener(pcl);
  }

  public void removePropertyChangeListener(PropertyChangeListener pcl){
    support.removePropertyChangeListener(pcl);
  }

  public void setWeather(String weather){
    support.firePropertyChange("weather-update", this.weather, weather);
    this.weather = weather;
  }
}
