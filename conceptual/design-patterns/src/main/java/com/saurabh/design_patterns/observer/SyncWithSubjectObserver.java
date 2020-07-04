package com.saurabh.design_patterns.observer;

public class SyncWithSubjectObserver implements Observer {
  private Subject subjectToObserve;
  private int currentValue;

  public SyncWithSubjectObserver(Subject sub) {
    subjectToObserve = sub;
    sub.subscribe(this);
  }

  @Override
  public void notify(int value) {
    currentValue = value;
  }

  @Override
  public int getCurrentValue() {
    return currentValue;
  }

  public void syncWithSubject() {
    currentValue = subjectToObserve.sync();
  }
}
