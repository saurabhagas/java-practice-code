package sandbox.oop;

public class MethodInnerClass {
  private int x = 24;
  public int getX() {
    String message = "x is";
    class Inner {
      private int x = MethodInnerClass.this.x;
      public void printX() {
        System.out.println(message + x);
      }
    }

    Inner in = new Inner();
    in.printX();
    return x;
  }

  public static void main(String[] args) {
    new MethodInnerClass().getX();
  }
}
