package com.saurabh.practice.concurrency;

import java.util.concurrent.CountDownLatch;

// printFirst(), printSecond() and printThird() is run by 3 different threads. Ensure they're always run in that order.
public class OrderedPrinting {
//  // Approach 1: maintain an atomic integer counter, and busy-wait on that everywhere
//  AtomicInteger counter = new AtomicInteger(1);
//
//  public static void main(String[] args) {
//    OrderedPrinting obj = new OrderedPrinting();
//    new Thread(obj::printThird).start();
//    new Thread(obj::printFirst).start();
//    new Thread(obj::printSecond).start();
//  }
//
//  public void printFirst() {
//    while (counter.get() != 1);
//    System.out.println("First");
//    counter.incrementAndGet();
//  }
//
//  public void printSecond() {
//    while (counter.get() != 2);
//    System.out.println("Second");
//    counter.incrementAndGet();
//  }
//
//  public void printThird() {
//    while (counter.get() != 3);
//    System.out.println("Third");
//    counter.incrementAndGet();
//  }

//  // Approach 2: maintain a counter, and use wait()/notifyAll() on this counter
//  int counter = 1;
//
//  public static void main(String[] args) {
//    OrderedPrinting obj = new OrderedPrinting();
//    new Thread(obj::printFirst).start();
//    new Thread(obj::printThird).start();
//    new Thread(obj::printSecond).start();
//  }
//
//  public synchronized void printFirst() {
//    while (counter != 1) {
//      waitWrapper();
//    }
//    System.out.println("First");
//    counter++;
//    System.out.println("Notifying");
//    notifyAll();
//    System.out.println("Notified. Sleeping now");
//    sleepWrapper();
//    System.out.println("Exiting");
//  }
//
//  public synchronized void printSecond() {
//    while (counter != 2) {
//      System.out.println("Thread 2: Waiting to be notified");
//      waitWrapper();
//      System.out.println("Thread 2: Woke up");
//    }
//    System.out.println("Second");
//    counter++;
//    notifyAll();
//  }
//
//  public synchronized void printThird() {
//    while (counter != 3) {
//      System.out.println("Thread 3: Waiting to be notified");
//      waitWrapper();
//      System.out.println("Thread 3: Woke up");
//    }
//    System.out.println("Third");
//    counter++;
//    notifyAll();
//  }

  // Approach 3: maintain 2 countdown latches with countDown() and await() between them
  private final CountDownLatch latch1 = new CountDownLatch(1);
  private final CountDownLatch latch2 = new CountDownLatch(1);

  public static void main(String[] args) {
    OrderedPrinting obj = new OrderedPrinting();
    new Thread(obj::printFirst).start();
    new Thread(obj::printThird).start();
    new Thread(obj::printSecond).start();
  }

  public void printFirst() {
    System.out.println("First");
    latch1.countDown();
  }

  public void printSecond() {
    latchAwait(latch1);
    System.out.println("Second");
    latch2.countDown();
  }

  public void printThird() {
    latchAwait(latch2);
    System.out.println("Third");
  }

  private void waitWrapper() {
    try {
      wait();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }

  private void latchAwait(CountDownLatch latch) {
    try {
      latch.await();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }

  private void sleepWrapper() {
    try {
      Thread.sleep(10_000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }
}
