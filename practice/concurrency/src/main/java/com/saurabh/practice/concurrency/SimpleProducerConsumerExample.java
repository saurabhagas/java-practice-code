package com.saurabh.practice.concurrency;

/**
 * A simple producer consumer solution with 1 Producer and 1 Consumer trying to exchange 1 message at a time.
 * Taken from https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
 */
public class SimpleProducerConsumerExample {
  public static void main(String[] args) {
    SingletonBlockingQueue<String> queue = new SingletonBlockingQueue<>();
    Thread producer = new Thread(new Producer(queue));
    Thread consumer = new Thread(new Consumer(queue));
    producer.start();
    consumer.start();
  }

  private static class Producer implements Runnable {
    private final SingletonBlockingQueue<String> queue;

    private Producer(SingletonBlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      for (int i = 0; i < 20; i++) {
        queue.offer("hello " + i);
      }
    }
  }

  private static class Consumer implements Runnable {
    private final SingletonBlockingQueue<String> queue;

    private Consumer(SingletonBlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      for (int i = 0; i < 20; i++) {
        System.out.println("Consumed: " + queue.poll());
      }
    }
  }

  private static class SingletonBlockingQueue<T> {
    private T current;
    private boolean produced;

    public synchronized T poll() {
      while (!produced) {
        waitNoException();
      }

      T item = current;
      produced = false;
      notifyAll();
      return item;
    }

    public synchronized void offer(T item) {
      while (produced) {
        waitNoException();
      }

      current = item;
      produced = true;
      notifyAll();
    }

    private void waitNoException() {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }
  }
}