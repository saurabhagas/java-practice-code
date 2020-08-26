package com.saurabh.practice.concurrency;

class Demonstration {
  public static void main(String[] args) throws InterruptedException {
    new IncorrectSynchronization().example();
  }
}

class IncorrectSynchronization {
  Boolean flag = Boolean.TRUE;

  public void example() throws InterruptedException {
    Thread t1 = new Thread(() -> {
      synchronized (flag) {
        try {
          while (flag) {
            System.out.println("First thread about to sleep");
            Thread.sleep(5000);
            System.out.println("Woke up and about to invoke wait()");

            // IllegalMonitorException here because the object on which the lock was acquired has changed, and a lock wasn't acquired on the new object
            flag.wait();
          }
        } catch (InterruptedException ie) {

        }
      }
    });

    Thread t2 = new Thread(() -> {
      flag = false;
      System.out.println("Boolean assignment done.");
    });

    t1.start();
    Thread.sleep(1000);
    t2.start();
    t1.join();
    t2.join();
  }
}