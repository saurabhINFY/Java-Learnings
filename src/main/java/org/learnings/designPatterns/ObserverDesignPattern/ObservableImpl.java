package org.learnings.designPatterns.ObserverDesignPattern;

public class ObservableImpl implements Observable{
    private int data;
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setData() {
        this.data = data;
        // once data is set, notify all observers
        notifyObservers();
    }
}
