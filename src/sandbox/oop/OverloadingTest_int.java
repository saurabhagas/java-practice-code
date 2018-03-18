package sandbox.oop;

/**
 * Following class demonstrates overloaded methods in decreasing priority when a primitive is an argument to the method call.
 * <p>The order is:</p>
 * <ol>
 *   <li>Exact type</li>
 *   <li>Larger type(larger primitive or parent class)</li>
 *   <li>Unboxed/Boxed variant</li>
 *   <li>Larger type of Unboxed/Boxed variant</li>
 *   <li>Varargs</li>
 * </ol>
 *
 * <p>Note that:</p>
 * <ol>
 *  <li>varargs and arrays are not the same, and methods accepting array parameters aren't even considered</li>
 *  <li>varargs with wrapper types and primitive types are considered equivalent</li>
 * </ol>
 */
public class OverloadingTest_int {
//  void test(int a) {
//    System.out.println("In int a");
//  }
//
//  void test(long a) {
//    System.out.println("In long a");
//  }
//
//  void test(Integer a) {
//    System.out.println("In Integer a");
//  }
//
  void test(Object a) {
    System.out.println("In Object a");
  }

  void test(long... a) {
    System.out.println("In long... a");
  }

  void test(Integer... a) {
    System.out.println("In Integer... a");
  }

//  void test(Integer[] a) {
//    System.out.println("In Integer[] a");
//  }

//  void test(int... a) {
//    System.out.println("In int... a");
//  }

//  void test(int[] a) {
//    System.out.println("In int[] a");
//  }

  public static void main(String[] args) {
    OverloadingTest_int obj = new OverloadingTest_int();
    System.out.println(obj);
    obj.test(5);
  }
}
