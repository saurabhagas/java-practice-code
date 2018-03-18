package sandbox.functional;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMap {
  @Test
  public void testWithIntArray() {
    int[] intArray = {1, 2, 3, 4, 5, 6};

    //1. Stream<int[]>
    Stream<int[]> streamArray = Stream.of(intArray);
    streamArray.forEach(System.out::println);//Prints toString of int[]

    //2. Stream<int[]> -> flatMap -> IntStream
//    IntStream intStream = streamArray.flatMapToInt(Arrays::stream);//IllegalStateException - stream has already been operated upon or closed
    IntStream intStream = Stream.of(intArray).flatMapToInt(Arrays::stream);
    intStream.forEach(System.out::println);
  }

  @Test
  public void testWithListContainingSets() {
    List<Developer> team = new ArrayList<>();
    Developer polyglot = new Developer("esoteric");
    polyglot.add("clojure");
    polyglot.add("scala");
    polyglot.add("groovy");
    polyglot.add("go");

    Developer busy = new Developer("pragmatic");
    busy.add("java");
    busy.add("javascript");

    team.add(polyglot);
    team.add(busy);

    //Goal is to print all the languages contained in all the Developer objects inside team List
    team.stream().map(Developer::getLanguages).flatMap(Collection::stream).forEach(System.out::println);
    //Alternatively,
    team.stream().flatMap(developer -> developer.getLanguages().stream()).forEach(System.out::println);
  }

  @Test
  public void testWithListofLists() {
    List<String> zero = Arrays.asList();
    List<String> one = Arrays.asList("Bonobo", "Bonobo Monkey");
    List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
    Stream<List<String>> animals = Stream.of(zero, one, two);
//    animals.flatMap(List::stream).sorted(String::compareTo).forEach(System.out::println);
    animals
        .flatMap(List::stream)
        .peek(System.out::println)
//        .sorted(Comparator.comparing((String s) -> s).thenComparing(String::length))
        .forEach(System.out::println);
  }
}

class Developer {

  private String name;
  private Set<String> languages;

  public Developer(String name) {
    this.languages = new HashSet<>();
    this.name = name;
  }

  public void add(String language) {
    this.languages.add(language);
  }

  public Set<String> getLanguages() {
    return languages;
  }
}
