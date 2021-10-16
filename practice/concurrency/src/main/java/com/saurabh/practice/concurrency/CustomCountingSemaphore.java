package com.saurabh.practice.concurrency;

import java.util.Random;

/**
 * Custom counting semaphore implementation with an upper bound
 */
public class CustomCountingSemaphore {
  private final int limit;
  private int current;

  public CustomCountingSemaphore(int limit) {
    this.limit = limit;
  }

  public synchronized void acquire() throws InterruptedException {
    while (current == 0) {
      wait();
    }

    current++;
    notifyAll();
  }

  public synchronized void release() throws InterruptedException {
    while (current == limit) {
      wait();
    }

    current--;
    notifyAll();
  }

  public static void main(String[] args) throws Exception {
    final CustomCountingSemaphore cs = new CustomCountingSemaphore(5);
    final Random random = new Random();

    Thread t1 = new Thread(() -> {
      try {
        for (int i = 1; i <= 5; i++) {
          System.out.println("Attempting to acquire " + i);
          cs.acquire();
          System.out.println("Acquired " + i);
          Thread.sleep(random.nextInt(10) * 1000);
        }
      } catch (InterruptedException ie) {

      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = 1; i <= 5; i++) {
        try {
          System.out.println("Attempting to release " + i);
          cs.release();
          System.out.println("Released " + i);
        } catch (InterruptedException ie) {

        }
      }
    });

    t2.start();
    t1.start();
  }
}
