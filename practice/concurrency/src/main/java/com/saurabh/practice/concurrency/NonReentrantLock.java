package com.saurabh.practice.concurrency;

// Deadlock with a single thread using non-reentrant lock
class NonReentrantLock {
  private boolean isLocked;

  public NonReentrantLock() {
    isLocked = false;
  }

  public synchronized void lock() throws InterruptedException {
    while (isLocked) {
      wait();
    }
    isLocked = true;
  }

  public synchronized void unlock() {
    isLocked = false;
    notify();
  }

  public static void main(String[] args) throws Exception {
    NonReentrantLock nreLock = new NonReentrantLock();

    // First locking would be successful
    nreLock.lock();
    System.out.println("Acquired first lock");

    // Second locking results in a self deadlock
    System.out.println("Trying to acquire second lock..");
    nreLock.lock();
    System.out.println("Acquired second lock");
  }
}