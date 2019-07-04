package com.saurabh.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class EveryUpdateSendingSubject implements Subject {
  private static final List<Observer> OBSERVERS = new ArrayList<>();
  private int eventCounter;

  @Override
  public void subscribe(Observer obj) {
    OBSERVERS.add(obj);
  }

  @Override
  public void unsubscribe(Observer obj) {
    OBSERVERS.remove(obj);
  }

  @Override
  public void generateEvent() {
    eventCounter++;
    notifyObservers();
  }

  @Override
  public void notifyObservers() {
    OBSERVERS.forEach(observer -> observer.notify(eventCounter));
  }

  @Override
  public void notifyObserver(Observer observer) {
    observer.notify(eventCounter);
  }

  @Override
  public int sync() {
    return eventCounter;
  }
}
