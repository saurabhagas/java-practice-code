package sandbox.functional;

import sandbox.common.Person;

public class TallPersonPredicate {
  public static boolean blah(Person person) {
    return person.getHeight() > 160;
  }
}
