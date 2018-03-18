package sandbox.concurrent;

public class CheckResults {
  private static int counter = 0;

  public static void main(String[] args) {
    Runnable runnable = () -> {
      for (int i = 0; i < 500; i++) counter++;
    };

    new Thread(runnable).start();
    while (counter < 100) {
      System.out.println("Not reached yet");
    }
    System.out.println("Reached!");
  }
}
