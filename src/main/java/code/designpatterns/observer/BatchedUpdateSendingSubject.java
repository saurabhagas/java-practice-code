package code.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class BatchedUpdateSendingSubject implements Subject {
  private static final List<Observer> OBSERVERS = new ArrayList<>();
  private final int batchSize;
  private int pendingUpdates;
  private int eventCounter;

  public BatchedUpdateSendingSubject(int batchSize) {
    this.batchSize = batchSize;
  }

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
    pendingUpdates++;
    if (pendingUpdates == batchSize) {
      OBSERVERS.forEach(observer -> observer.notify(eventCounter));
      pendingUpdates = 0;
    }
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
