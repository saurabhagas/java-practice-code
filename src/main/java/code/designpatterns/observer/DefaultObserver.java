package code.designpatterns.observer;

public class DefaultObserver implements Observer {
  private int currentValue;

  public DefaultObserver(Subject sub) {
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
}
