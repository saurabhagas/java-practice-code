package com.saurabh.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * DiningPhilosophers implementation with pluggable deadlock resolution strategy
 */
interface Eater {
  void eat(int id) throws InterruptedException;
}

class EaterFactory {
  static Eater create(int numPhilosophers, DiningPhilosophers.EatingStrategy strategy) {
    switch (strategy) {
      case NONE:
        return new DeadlockingEater(numPhilosophers);
      case ACQUIRE_AND_YIELD_FORKS:
        return new AcquireAndYieldingPhilosopherEater(numPhilosophers);
      case LEFT_HANDED_PHILOSOPHERS:
        return new LeftHandedPhilosopherEater(numPhilosophers);
      case LIMIT_CONCURRENT_PHILOSOPHERS:
        return new ConcurrentPhilosophersLimitingEater(numPhilosophers);
      default:
        throw new IllegalArgumentException("Unknown strategy: " + strategy);
    }
  }
}

class ConcurrentPhilosophersLimitingEater implements Eater {
  private final int numPhilosophers;
  private final Semaphore[] forks;
  private final Semaphore concurrentPhilosophersLimiter;

  public ConcurrentPhilosophersLimitingEater(int numPhilosophers) {
    this.numPhilosophers = numPhilosophers;
    this.forks = new Semaphore[numPhilosophers];
    for (int i = 0; i < numPhilosophers; i++) {
      this.forks[i] = new Semaphore(1);
    }
    this.concurrentPhilosophersLimiter = new Semaphore(numPhilosophers - 1);
  }

  @Override
  public void eat(int id) throws InterruptedException {
    concurrentPhilosophersLimiter.acquire();

    forks[id].acquire();
    forks[(id + 1) % numPhilosophers].acquire();

    System.out.println("Philosopher " + id + " eating");

    forks[(id + 1) % numPhilosophers].release();
    forks[id].release();
    concurrentPhilosophersLimiter.release();
  }
}

class AcquireAndYieldingPhilosopherEater implements Eater {
  private final int numPhilosophers;
  private final Semaphore[] forks;

  public AcquireAndYieldingPhilosopherEater(int numPhilosophers) {
    this.numPhilosophers = numPhilosophers;
    this.forks = new Semaphore[numPhilosophers];
    for (int i = 0; i < numPhilosophers; i++) {
      this.forks[i] = new Semaphore(1);
    }
  }

  @Override
  public void eat(int id) {
    boolean bothForksAcquired = false;
    while (!bothForksAcquired) {
      boolean acquiredFirst = forks[id].tryAcquire();
      boolean acquiredSecond = forks[(id + 1) % numPhilosophers].tryAcquire();
      bothForksAcquired = acquiredFirst && acquiredSecond;
      if (!bothForksAcquired) {
        forks[id].release();
        forks[(id + 1) % numPhilosophers].release();
      }
    }

    System.out.println("Philosopher " + id + " eating");

    forks[(id + 1) % numPhilosophers].release();
    forks[id].release();
  }
}

class DeadlockingEater implements Eater {
  private final int numPhilosophers;
  private final Semaphore[] forks;

  public DeadlockingEater(int numPhilosophers) {
    this.numPhilosophers = numPhilosophers;
    this.forks = new Semaphore[numPhilosophers];
    for (int i = 0; i < numPhilosophers; i++) {
      this.forks[i] = new Semaphore(1);
    }
  }

  @Override
  public void eat(int id) throws InterruptedException {
    forks[id].acquire();
    forks[(id + 1) % numPhilosophers].acquire();

    System.out.println("Philosopher " + id + " eating");

    forks[(id + 1) % numPhilosophers].release();
    forks[id].release();
  }
}

class LeftHandedPhilosopherEater implements Eater {
  private final int numPhilosophers;
  private final Semaphore[] forks;

  public LeftHandedPhilosopherEater(int numPhilosophers) {
    this.numPhilosophers = numPhilosophers;
    this.forks = new Semaphore[numPhilosophers];
    for (int i = 0; i < numPhilosophers; i++) {
      this.forks[i] = new Semaphore(1);
    }
  }

  @Override
  public void eat(int id) throws InterruptedException {
    if (id == numPhilosophers / 2) {
      //make the middle philosopher left-handed
      forks[(id + 1) % numPhilosophers].acquire();
      forks[id].acquire();
    } else {
      forks[id].acquire();
      forks[(id + 1) % numPhilosophers].acquire();
    }

    System.out.println("Philosopher " + id + " eating");

    forks[(id + 1) % numPhilosophers].release();
    forks[id].release();
  }
}

public class DiningPhilosophers {
  private final Eater eater;

  enum EatingStrategy {
    LIMIT_CONCURRENT_PHILOSOPHERS,
    LEFT_HANDED_PHILOSOPHERS,
    ACQUIRE_AND_YIELD_FORKS,
    NONE
  }

  public DiningPhilosophers(int numPhilosophers, EatingStrategy strategy) {
    this.eater = EaterFactory.create(numPhilosophers, strategy);
  }

  public void start(int id) {
    try {
      think(id);
      eater.eat(id);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
  }

  private void think(int id) throws InterruptedException {
    System.out.println("Philosopher " + id + " thinking");
    Thread.sleep(50);
  }

  public static void main(String[] args) throws InterruptedException {
    final int numPhilosophers = 5;
    final DiningPhilosophers dp = new DiningPhilosophers(numPhilosophers, EatingStrategy.ACQUIRE_AND_YIELD_FORKS);
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < numPhilosophers; i++) {
      int finalI = i;
      threads.add(new Thread(() -> dp.start(finalI)));
    }

    for (Thread thread : threads) {
      thread.start();
    }

    for (Thread thread : threads) {
      thread.join();
    }
  }
}
