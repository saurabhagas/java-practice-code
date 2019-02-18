package code.concurrent;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

public class CallbackRegistrationDemo {
  private final PriorityQueue<CallBackWrapper> minHeap = new PriorityQueue<>(Comparator.comparing(o -> o.executeAt));
  private final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

  // Run by the Executor Thread
  public synchronized void start() throws InterruptedException {
    System.out.println("In start");
    long sleepForSeconds = 0;
    int lastSeenQSize = 0;

    while (true) {
      while (minHeap.size() == 0) {
        wait();
      }

      if (lastSeenQSize == minHeap.size()) {
        wait(sleepForSeconds * 1000);
      }

      final LocalTime currentTime = LocalTime.now();
      while (minHeap.size() != 0 && currentTime.compareTo(minHeap.peek().executeAt) >= 0) {
        CallBackWrapper cb = minHeap.poll();
        System.out.println("Executed at " + LocalTime.now().format(formatter) + ", required at: " + cb.executeAt.format(formatter) + " message: " + cb.callBack.get());
      }

      if (minHeap.peek() != null) {
        sleepForSeconds = minHeap.peek().executeAt.toSecondOfDay() - currentTime.toSecondOfDay();
        lastSeenQSize = minHeap.size();
      } else {
        sleepForSeconds = 0;
      }
    }
  }

  // Called by Consumer Threads to register callback
  public synchronized <T> void registerCallback(Supplier<T> callBack, LocalTime executeAt) {
    System.out.println("Registered callback to be executed at: " + executeAt.format(formatter));
    minHeap.add(new CallBackWrapper<>(callBack, executeAt));
    notify();
  }

  private static class CallBackWrapper<T> {
    private final LocalTime executeAt;
    private final Supplier<T> callBack;

    CallBackWrapper(Supplier<T> callBack, LocalTime executeAt) {
      this.executeAt = executeAt;
      this.callBack = callBack;
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Set<Thread> allThreads = new HashSet<>();
    Random random = new Random();
    final CallbackRegistrationDemo deferredCallbackExecutor = new CallbackRegistrationDemo();

    Thread service = new Thread(() -> {
      try {
        deferredCallbackExecutor.start();
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
      }
    });

    service.start();
    for (int i = 0; i < 10; i++) {
      String name = "Thread_" + (i + 1);
      int finalI = i;
      final Runnable runnable = () -> {
        LocalTime executeAt;
        if (finalI == 3 || finalI == 5) {
          executeAt = LocalTime.now().plusSeconds(1);
        } else {
          executeAt = LocalTime.now().plusMinutes(1);
        }
        deferredCallbackExecutor.registerCallback(() -> "Hello this is " + name, executeAt);
      };
      Thread thread = new Thread(runnable);
      thread.setName(name);
      thread.start();
      allThreads.add(thread);
      Thread.sleep((random.nextInt(3) + 1) * 1000);
    }

    for (Thread t : allThreads) {
      t.join();
    }
  }
}