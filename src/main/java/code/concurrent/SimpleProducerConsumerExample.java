package code.concurrent;

/**
 * A simple producer consumer solution with 1 Producer and 1 Consumer trying to exchange 1 message at a time.
 * Taken from https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
 */
public class SimpleProducerConsumerExample {
  public static void main(String[] args) throws Exception {
    final OneElementQueue queue = new OneElementQueue();

    // Producer and consumer synchronize on the same queue
    final Thread producer = new Thread(new Producer(queue));
    final Thread consumer = new Thread(new Consumer(queue));
    producer.start();
    consumer.start();

    // Wait for both threads to finish
    producer.join();
    consumer.join();
  }

  private static class Consumer implements Runnable {
    private OneElementQueue queue;

    Consumer(OneElementQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      String message;
      do {
        message = queue.get();
        System.out.println("Consumer received: " + message);
      } while (!message.equals("DONE"));
    }
  }

  private static class Producer implements Runnable {
    private OneElementQueue queue;

    Producer(OneElementQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      String baseMessage = "hello";
      for (int i = 1; i <= 5; i++) {
        final String message = baseMessage + " " + i;
        System.out.println("Producer putting: " + message);
        queue.put(message);
      }
      queue.put("DONE");
    }
  }

  private static class OneElementQueue {
    private String message;
    private boolean producerWrote = false;
    synchronized String get() {
      // Don't consume until you need to consume
      while (!producerWrote) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      producerWrote = false;
      notifyAll();
      return message;
    }

    synchronized void put(String message) {
      // Don't produce until you need to produce
      while (producerWrote) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      this.message = message;
      producerWrote = true;
      notifyAll();
    }
  }
}