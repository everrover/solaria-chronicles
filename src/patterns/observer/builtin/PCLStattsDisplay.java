package patterns.observer.builtin;

import patterns.observer.interfaces.Display;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

public class PCLStattsDisplay implements PropertyChangeListener, Display {
  private String news;

  public PCLStattsDisplay() { this.news = ""; }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    this.setNews((String) evt.getNewValue());
    this.display();
  }

  @Override
  public void display() {
    System.out.println("PCLStattsDisplay: "+news);
  }

  public String getNews() {
    return news;
  }
  public void setNews(String news) {
    this.news = news;
  }
}
