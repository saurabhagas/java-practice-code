package code.generics;

public class GenericClass<T> {
  private T t;
  
  public GenericClass(T t) {
    this.t = t;
  }

  @Override
  public String toString() {
    System.out.println(t.getClass());
    return t.toString();
  }

  public static void main(String[] args) {
    System.out.println(new GenericClass<String>("Hi")); //String inside diamond is not needed
    System.out.println(new GenericClass<>("Hi")); //String inside diamond is not needed
    System.out.println(new GenericClass("Hello")); //Non-generic way of calling
    System.out.println(new GenericClass(5)); //Non-generic way of calling
  }
}
