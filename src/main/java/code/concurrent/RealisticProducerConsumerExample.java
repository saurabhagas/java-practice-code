package code.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * A producer consumer solution with 1 Producer and 2 Consumers trying to exchange message through a shared BlockingQueue.
 */
public class RealisticProducerConsumerExample {
  public static void main(String[] args) throws Exception {
    final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    // Producer and consumer synchronize on the same queue
    final Thread producer = new Thread(new Producer(queue));
    final Thread consumer1 = new Thread(new Consumer(queue));
    final Thread consumer2 = new Thread(new Consumer(queue));
    producer.start();
    consumer1.start();
    consumer2.start();

    // Wait for both threads to finish
    producer.join();
    consumer1.join();
    consumer2.join();
  }

  private static class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    Consumer(BlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      String message;
      for (int i = 1; i <= 10; i++) {
        try {
          message = queue.take();
          System.out.println("Consumer with Thread ID: " + Thread.currentThread().getName() + " received: " + message);
        } catch (InterruptedException e) {
          // Ignore
        }
      }
    }
  }

  private static class Producer implements Runnable {
    private BlockingQueue<String> queue;

    Producer(BlockingQueue<String> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      String baseMessage = "hello";
      for (int i = 1; i <= 20; i++) {
        final String message = baseMessage + " " + i;
        System.out.println("Producer putting: " + message);
        try {
          queue.put(message);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}