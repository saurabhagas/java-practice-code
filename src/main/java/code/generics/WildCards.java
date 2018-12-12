package code.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCards {
  private static List<Object> exceptions;
  private static List<? extends Object> names = new ArrayList<Object>();

  public static void main(String[] args) {
    exceptions.add(new Object());
    exceptions.add(new String());
    exceptions.add(new Integer(4));
    exceptions.add(10.0);

//    names.add(new Object());
//    names.add(new String());
  }
}
