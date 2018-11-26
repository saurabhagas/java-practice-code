package sandbox.functional;

import java.util.function.Function;

/**
 * Function Currying is a concept of breaking a function with many arguments into many functions with single argument in
 * a way such that the output is same.
 */
public class CurryFunctions {
  public static void main(String[] args) {
    Function<Integer, Function<Integer, Integer>> curryAdd = u -> v -> u + v;
    int curryResult = curryAdd.apply(2).apply(3);
    System.out.println(curryResult);
  }
}
