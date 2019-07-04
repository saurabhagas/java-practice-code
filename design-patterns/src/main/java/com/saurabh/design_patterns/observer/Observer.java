package com.saurabh.design_patterns.observer;

public interface Observer {
  void notify(int value);

  int getCurrentValue();
}
