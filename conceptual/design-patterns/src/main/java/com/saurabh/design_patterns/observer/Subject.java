package com.saurabh.design_patterns.observer;

public interface Subject {

  void subscribe(Observer observer);

  void unsubscribe(Observer observer);

  void generateEvent();

  void notifyObservers();

  void notifyObserver(Observer observer);

  /**
   * Special method for a given Observer to request the {@code Subject} to give the latest value of the observed value.
   */
  int sync();
}
