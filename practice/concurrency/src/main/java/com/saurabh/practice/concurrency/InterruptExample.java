package com.saurabh.practice.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Demo {
  public static void main(String[] args) throws Exception {
    new InterruptExample().example();
  }
}

class InterruptExample {
  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();

  public void example() throws InterruptedException {
    final Thread sleepyThread = new Thread(() -> {
      try {
        System.out.println("Spawned thread sleeping for an hour zZZZ");
        lock.lock();
        condition.signal();
        lock.unlock();
        Thread.sleep(1000 * 60 * 60);
      } catch (InterruptedException ie) {
        System.out.println("Someone woke me up :( ");
        System.out.println("Is interrupt flag set? " + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("Is interrupt flag set? " + Thread.currentThread().isInterrupted());
      }
    });

    System.out.println("Starting thread ...");
    sleepyThread.start();

    lock.lock();
    condition.await();
    lock.unlock();
    System.out.println("About to wake up the sleepy thread ...");
    sleepyThread.interrupt();
  }
}
