package sandbox.functional;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamOperations {
  public static void main(String[] args) {
//    DoubleStream doubleStream = DoubleStream.of(2.0, 3.0);
//    doubleStream.count(); //count operation is defined on DoubleStream

//    Stream<Integer> orderedInfiniteStream = Stream.iterate(0, integer -> 60);//Returns an infinite sequential ordered stream based on the given seed and the operator
//    orderedInfiniteStream.limit(10).forEach(System.out::println);

//    boolean anyMatch = Stream.iterate(0, integer -> integer + 10)
////        .limit(10)
//        .anyMatch(entry -> entry > 50);
//    System.out.println(anyMatch);
//    boolean noneMatch = Stream.iterate(0, integer -> integer + 10)
////        .limit(10)
//        .noneMatch(entry -> entry > 50);
//    System.out.println(noneMatch);
//    boolean allMatch = Stream.iterate(0, integer -> integer + 10)
////        .limit(10)
//        .allMatch(entry -> entry > 50);
//    System.out.println(allMatch);

    Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
    System.out.println(Stream.generate(() -> "chimp").peek(System.out::println).anyMatch(pred));
    System.out.println(Stream.generate(() -> "chimp").peek(System.out::println).noneMatch(pred));
//    System.out.println(Stream.generate(() -> "chimp").allMatch(pred)); // Hangs

    Stream<String> stream = Stream.of("w", "o", "l", "f");
    StringBuilder word = stream.collect(() -> new StringBuilder(), (stringBuilder, str) -> stringBuilder.append(str), StringBuilder::append);
    System.out.println(word);

//    Optional<Integer> findAny = Stream.iterate(0, integer -> integer + 1).limit(10).findAny();
//    Optional<Integer> findFirst = Stream.iterate(0, integer -> integer + 1).limit(10).findFirst();
//
//    findAny.ifPresent(System.out::println);
//    findFirst.ifPresent(System.out::println);

//    Stream<Integer> unorderedInfiniteStream = Stream.generate(() -> 100);//Returns an infinite sequential unordered stream consisting of identical elements
//    unorderedInfiniteStream.limit(10).forEach(System.out::println);
  }
}