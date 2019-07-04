package com.saurabh.functional;

import com.saurabh.common.Person;

public class TallPersonPredicate {
  public static boolean blah(Person person) {
    return person.getHeight() > 160;
  }
}
