package com.saurabh.practice.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Print 1, 2, 3 in order forever
 */
public class OrderedPrinting {
  private static final int NUM_THREADS = 3;

  public static void main(String[] args) {
//    new BusyWaitImplementation().execute();
    new TokenBasedImplementation().execute();
  }

  private static void await(Condition condition) {
    try {
      condition.await();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }

  private static void sleep() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }
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
//  private final CountDownLatch latch1 = new CountDownLatch(1);
//  private final CountDownLatch latch2 = new CountDownLatch(1);
//
//  public static void main(String[] args) {
//    OrderedPrinting obj = new OrderedPrinting();
//    new Thread(obj::printFirst).start();
//    new Thread(obj::printThird).start();
//    new Thread(obj::printSecond).start();
//  }
//
//  public void printFirst() {
//    System.out.println("First");
//    latch1.countDown();
//  }
//
//  public void printSecond() {
//    latchAwait(latch1);
//    System.out.println("Second");
//    latch2.countDown();
//  }
//
//  public void printThird() {
//    latchAwait(latch2);
//    System.out.println("Third");
//  }

  private static class TokenBasedImplementation {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final AtomicReference<String> owner = new AtomicReference<>();

    private final Runnable first = () -> {
      while (true) {
        System.out.println("Acquiring lock in 1");
        lock.lock();
        System.out.println("Checking owner in 1");
        while (!owner.get().equals("1")) await(condition);
        System.out.println("1");
        owner.set("2");
        System.out.println("Signalling in 1");

        condition.signal();
        lock.unlock();
      }
    };
    private final Runnable second = () -> {
      while (true) {
        System.out.println("Acquiring lock in 2");
        lock.lock();
        System.out.println("Checking owner in 2");
        while (!owner.get().equals("2")) await(condition);
        System.out.println("2");
        owner.set("3");
        System.out.println("Signalling in 2");
        condition.signal();
        lock.unlock();
      }
    };
    private final Runnable third = () -> {
      while (true) {
        System.out.println("Acquiring lock in 3");
        lock.lock();
        System.out.println("Checking owner in 3");
        while (!owner.get().equals("3")) await(condition);
        System.out.println("3");
        owner.set("1");
        System.out.println("Signalling in 3");
        condition.signal();
        lock.unlock();
      }
    };

    public void execute() {
      owner.set("1");
      // The output should be correct irrespective of the order of start
      new Thread(second).start();
      new Thread(third).start();
      new Thread(first).start();
    }
  }

  private static class BusyWaitImplementation {
    AtomicInteger counter = new AtomicInteger(0);

    Runnable third = () -> {
      while (true) {
        while (counter.get() % NUM_THREADS != 2) ;
        System.out.println("3");
        counter.incrementAndGet();
        sleep();
      }
    };
    Runnable second = () -> {
      while (true) {
        while (counter.get() % NUM_THREADS != 1) ;
        System.out.println("2");
        counter.incrementAndGet();
        sleep();
      }
    };
    Runnable first = () -> {
      while (true) {
        while (counter.get() % NUM_THREADS != 0) ;
        System.out.println("1");
        counter.incrementAndGet();
        sleep();
      }
    };

    public void execute() {
      // The output should be correct irrespective of the order of start
      new Thread(second).start();
      new Thread(third).start();
      new Thread(first).start();
    }
  }
}
