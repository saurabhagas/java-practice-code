package code.oop;

public class InnerOuter {
  private int shade = 255;
  private static String color = "Red";

  public static void main(String[] args) {
//    System.out.println(new NonStaticNestedOrInner().hue); Inner class doesn't exist without outer class object
    InnerOuter innerOuter = new InnerOuter();
    System.out.println(innerOuter.new NonStaticNestedOrInner().hue);
    System.out.println(StaticNested.color2);
    System.out.println(new StaticNested().hue);
  }

  class NonStaticNestedOrInner {
    private int hue = shade; // Can access outer variables directly
    private String color2 = color; // Can access outer variables directly
//    private static String color = InnerOuter.color; // Cannot have static fields
  }

  static class StaticNested {
    private int hue = new InnerOuter().shade; // Can access instance variables through objects
    private static String color2 = color; // Can access static outer variables directly
    private static String shade = InnerOuter.color; // Can have static members
  }
}
