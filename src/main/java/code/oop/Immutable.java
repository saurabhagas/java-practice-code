package code.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Immutable {
  private List<String> heights;

  public Immutable(List<String> heights) {
    //Defensive copy at the time of creation for mutable constituent objects
    this.heights = new ArrayList<>(heights);
  }

  public List<String> getHeights() {
    //Return an unmodifiable copy for mutable objects
    return Collections.unmodifiableList(heights);
  }

  // Do not allow setters for mutable objects
}

class ImmutableDemo {
  public static void main(String[] args) {
    final ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("A", "B"));
    final Immutable immutable = new Immutable(alphabet);
    System.out.println(immutable.getHeights());

    alphabet.add("C");
    System.out.println(immutable.getHeights());

  }
}