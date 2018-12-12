package code.concurrent;

import java.util.stream.Stream;

/**
 * SortedStream
 */
public class SortedStream {
  public static void main(String[] args) {
    Integer integer = Stream.of(10, 2, 3, 4, 5)
        .parallel()
        .sorted()
//        .findAny()
        .findFirst()
        .get();
    System.out.println(integer);
  }
}
