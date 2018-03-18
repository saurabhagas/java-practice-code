package sandbox.functional;

import sandbox.common.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StreamFilterTest {
  public static void main(String[] args) {
    List<Person> personList = new ArrayList<>();
    //name, age, height
    personList.add(new Person("Saurabh", 10, 185));
    personList.add(new Person("Rajesh", 20, 100));
    personList.add(new Person("Sogani", 30, 160));
    personList.add(new Person("Behen", 40, 180));
    personList.add(new Person("Mahesh", 50, 145));
    personList.add(new Person("Suresh", 70, 125));
    personList.add(new Person("Ajit", 15, 115));
    personList.add(new Person("Amit", 25, 155));
    personList.add(new Person("Ankit", 35, 185));

    //Tall and old people
    personList.stream()
        .filter(isPersonOld())
        .filter(isPersonTall())
        .forEach(System.out::println);

    //Tall young adults whose names start with "A"
    personList.stream()
        .filter(isPersonYoungAdult())
        .filter(TallPersonPredicate::blah)
        .filter(person -> person.getName().startsWith("A"))
        .forEach(System.out::println);

    //Young and short people
    personList.stream()
        .filter(isPersonYoung())
        .filter(isPersonShort())
        .forEach(System.out::println);
  }

  private static Predicate<Person> isPersonShort() {
    return person -> person.getHeight() < 150;
  }

  private static Predicate<Person> isPersonTall() {
    return person -> person.getHeight() >= 160;
  }

  private static Predicate<Person> isPersonYoung() {
    return person -> person.getAge() < 18;
  }

  private static Predicate<Person> isPersonYoungAdult() {
    return person -> person.getAge() <= 30 && person.getAge() >= 18;
  }

  private static Predicate<Person> isPersonOld() {
    return person -> person.getAge() >= 40;
  }
}
