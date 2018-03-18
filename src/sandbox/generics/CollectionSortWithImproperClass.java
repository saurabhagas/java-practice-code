package sandbox.generics;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * CollectionSortWithImproperClass
 */
public class CollectionSortWithImproperClass {
  static class Lizard implements Comparator<Lizard> {
    int weight;
    Lizard(int weight) {
      this.weight = weight;
    }

    @Override
    public int compare(Lizard first, Lizard second) {
      return first.weight - second.weight;
    }

    @Override
    public String toString() {
      return "" + weight;
    }
  }

  public static void main(String[] args) {
    ArrayList<Lizard> list = new ArrayList<>();
    list.add(new Lizard(5));
    list.add(new Lizard(7));
    list.add(new Lizard(4));

    list.sort(Comparator.comparingInt(o -> o.weight));
    System.out.println(list);
//    Collections.sort(list); //only works for List containing comparable elements
//    Collections.sort(new HashSet<>()); //only works for List
  }
}
