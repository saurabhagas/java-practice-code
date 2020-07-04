package com.saurabh.conceptual.functional;

import com.saurabh.source.common.Person;

public class TallPersonPredicate {
  public static boolean blah(Person person) {
    return person.getHeight() > 160;
  }
}
