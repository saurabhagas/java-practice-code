package com.saurabh.practice.concurrency;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;

/**
 * A sample program demonstrating the use of Semaphore. Unlike locks, semaphores don't exhibit the problem of lost signals.
 *
 * Java semaphores don't have an upper bound on the resources. Also, users of this API are expected to `acquire` and `release`
 * the semaphore in balanced amounts.
 */
public class SemaphoreDemo {
  public static void main(String[] args) throws InterruptedException {
    FixedMissedSignalExample.example();
  }
}

class FixedMissedSignalExample {
  static void example() throws InterruptedException {
    final Semaphore semaphore = new Semaphore(0);
    final int startTime = LocalTime.now().getSecond();

    Thread signaller = new Thread(() -> {
      System.out.println("Trying to release semaphore at: " + (LocalTime.now().getSecond() - startTime) + " seconds. Available permits are: " + semaphore.availablePermits());
      semaphore.release();
      System.out.println("Released semaphore at: " + (LocalTime.now().getSecond() - startTime) + " seconds. Available permits are: " + semaphore.availablePermits());
    });

    Thread waiter = new Thread(() -> {
      try {
        System.out.println("Trying to acquire semaphore at: " + (LocalTime.now().getSecond() - startTime) + " seconds. Available permits are: " + semaphore.availablePermits());
        semaphore.acquire();
        System.out.println("Acquired semaphore at: " + (LocalTime.now().getSecond() - startTime) + " seconds. Available permits are: " + semaphore.availablePermits());
      } catch (InterruptedException ie) {
        // handle interruption
      }
    });

    waiter.start();
    System.out.println("Main thread sleeping at: " + (LocalTime.now().getSecond() - startTime) + " seconds");
    Thread.sleep(10000);
    System.out.println("Main thread woke up at: " + (LocalTime.now().getSecond() - startTime) + " seconds");

    signaller.start();
    signaller.join();
    waiter.join();

    System.out.println("Program Exiting.");
  }
}
