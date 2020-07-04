package com.saurabh.practice.concurrency;

public class CustomBarrier {
  private final int maxThreads;
  private int threadsInBarrier;
  private int released;

  public CustomBarrier(int maxThreads) {
    this.maxThreads = maxThreads;
  }

  public synchronized void await() throws InterruptedException {
    // Do not allow more threads to enter if the current barrier isn't broken
    if (threadsInBarrier == maxThreads) {
      wait();
    }

    threadsInBarrier++;

    if (threadsInBarrier == maxThreads) {
      notifyAll();
      released = maxThreads;
    } else {
      while (threadsInBarrier < maxThreads) {
        wait();
      }
    }

    released--;
    if (released == 0) {
      threadsInBarrier = 0;
      notifyAll();
    }
  }
}

