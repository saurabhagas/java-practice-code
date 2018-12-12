package code.functional;

import code.common.Person;

public class TallPersonPredicate {
  public static boolean blah(Person person) {
    return person.getHeight() > 160;
  }
}
