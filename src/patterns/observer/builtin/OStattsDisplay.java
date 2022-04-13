package patterns.observer.builtin;

import patterns.observer.interfaces.Display;

import java.util.Observable;
import java.util.Observer;

public class OStattsDisplay implements Observer, Display {
  private String news;

  public OStattsDisplay(Observable obs) {
    obs.addObserver(this);
    this.news = news;
  }

  @Override
  public void display() {
    System.out.println("OStatsDisplay: "+news);
  }

  @Override
  public void update(Observable obs, Object news){
    this.setNews((String) news);
    display();
  }

  public String getNews() {
    return news;
  }

  public void setNews(String news) {
    this.news = news;
  }
}
