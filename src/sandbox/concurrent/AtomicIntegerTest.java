package sandbox.concurrent;

import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
//  private static final AtomicInteger sheepCount = new AtomicInteger(0);
//  private static void incrementAndReport() {
//    System.out.print(sheepCount.incrementAndGet()+" ");
//  }
//
//  public static void main(String[] args) {
//    ExecutorService executorService = Executors.newFixedThreadPool(10);
//    for (int i = 0; i < 10; i++) {
//      executorService.submit(AtomicIntegerTest::incrementAndReport);
//    }
//
//    executorService.shutdown();
//  }

  private AtomicInteger sheepCount = new AtomicInteger(0);

  private void incrementAndReport() {
    PrintStream out = System.out;
    out.println(sheepCount.incrementAndGet() + " ");
  }

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(20);
      AtomicIntegerTest manager = new AtomicIntegerTest();
      for (int i = 0; i < 10; i++)
        service.submit(manager::incrementAndReport);
    } finally {
      if (service != null) service.shutdown();
    }
  }
}
