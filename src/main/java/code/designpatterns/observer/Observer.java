package code.designpatterns.observer;

public interface Observer {
  void notify(int value);

  int getCurrentValue();
}
