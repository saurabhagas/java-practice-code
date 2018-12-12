package code.functional;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamReduction {
  public static void main(String[] args) {
    BinaryOperator<Integer> op = (a, b) -> a * b;
    Stream<Integer> empty = Stream.empty();
    Stream<Integer> oneElement = Stream.of(3);
    Stream<Integer> threeElements = Stream.of(3, 5, 6);
    empty.reduce(op).ifPresent(System.out::print); // no output
    empty = Stream.empty();
    System.out.println(empty.reduce(1, op)); // Identity is the output

    oneElement.reduce(op).ifPresent(System.out::println); // 3
    oneElement = Stream.of(3);
    System.out.println(oneElement.reduce(1, op)); // 3
    threeElements.reduce(op).ifPresent(System.out::println); // 90
  }
}
