package patterns.observer.interfaces;

public interface Observed {
    public boolean registerObserver(Observer obs);
    public boolean unregisterObserver(Observer obs);
    public boolean notifyObservers();

    public int getData();
    public void setData(int data);
}
