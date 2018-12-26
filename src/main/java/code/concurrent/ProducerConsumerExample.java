package code.concurrent;

import java.util.Random;

// Taken from https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
public class ProducerConsumerExample {
  public static void main(String[] args) {
    Drop drop = new Drop();
    (new Thread(new Producer(drop))).start();
    (new Thread(new Consumer(drop))).start();
  }

  private static class Consumer implements Runnable {
    private Drop drop;

    Consumer(Drop drop) {
      this.drop = drop;
    }

    public void run() {
      Random random = new Random();
      for (String message = drop.take();
           !message.equals("DONE");
           message = drop.take()) {
        System.out.format("MESSAGE RECEIVED: %s%n", message);
        try {
          Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
          //Ignore
        }
      }
    }
  }

  private static class Producer implements Runnable {
    private Drop drop;

    Producer(Drop drop) {
      this.drop = drop;
    }

    public void run() {
      String[] importantInfo = {
          "Mares eat oats",
          "Does eat oats",
          "Little lambs eat ivy",
          "A kid will eat ivy too"
      };
      Random random = new Random();

      for (String s : importantInfo) {
        drop.put(s);
        try {
          Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
          //Ignore
        }
      }
      drop.put("DONE");
    }
  }

  private static class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait for producer to send message, false if producer should wait for consumer to retrieve it.
    private boolean empty = true;

    synchronized String take() {
      // Wait until message is available.
      while (empty) {
        try {
          wait();
        } catch (InterruptedException e) {
          //Ignore
        }
      }
      // Toggle status.
      empty = true;
      // Notify producer that status has changed.
      notifyAll();
      return message;
    }

    synchronized void put(String message) {
      // Wait until message has been retrieved.
      while (!empty) {
        try {
          wait();
        } catch (InterruptedException e) {
          //Ignore
        }
      }
      // Toggle status.
      empty = false;
      // Store message.
      this.message = message;
      // Notify consumer that status has changed.
      notifyAll();
    }
  }
}