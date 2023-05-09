package com.saurabh.practice.concurrency;

import java.util.concurrent.Semaphore;

public class ReadWriteLock {
  private final Semaphore writeSem = new Semaphore(1);
  private final Semaphore readSem = new Semaphore(Integer.MAX_VALUE);

  public synchronized void acquireReadLock() throws InterruptedException {
    while (writeSem.availablePermits() == 0) {
      wait();
    }

    readSem.acquire();
  }

  public synchronized void releaseReadLock() {
    readSem.release();
    notifyAll();
  }

  public synchronized void acquireWriteLock() throws InterruptedException {
    while (readSem.availablePermits() != Integer.MAX_VALUE) {
      wait();
    }
    writeSem.acquire();
  }

  public synchronized void releaseWriteLock() {
    writeSem.release();
    notifyAll();
  }
}
