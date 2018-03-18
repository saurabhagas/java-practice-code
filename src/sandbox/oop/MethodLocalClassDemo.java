package sandbox.oop;

import org.junit.Test;

/**
 * MethodLocalClassDemo
 */
public class MethodLocalClassDemo {
  static int number = 10;
  public static void main(String[] args) {
    number++;
    for (int i = 0; i < 5; i++) {
      class MethodLocal { //No access modifiers allowed
        public int num = 5; //Allowed
//        public static int staticNum = 5; //Not allowed - can't have static fields
        public void doStuff() { //Allowed
//          System.out.println(i); //Not allowed since i isn't effectively final
          System.out.println(number);//Allowed - "effectively final" is only applicable to local variables
        }

//        public static void doOtherStuff() {} Not allowed - can't have static methods
      }

      new MethodLocal().doStuff();
    }
  }

  @Test
  public void testMethodLocalClass(){
    number++;
    for (int i = 0; i < 5; i++) {
      class MethodLocal {
        public int num = 5; //Allowed
//        public static int staticNum = 5; //Not allowed - can't have static fields
        public void doStuff() { //Allowed
//          System.out.println(i); //Not allowed since i isn't effectively final
          System.out.println(number);//Allowed - "effectively final" is only applicable to local variables
        }

//        public static void doOtherStuff() {} Not allowed - can't have static methods
      }

      new MethodLocal().doStuff();
    }
  }
}
