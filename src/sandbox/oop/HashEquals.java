package sandbox.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class HashEquals {
  public static void main(String[] args) {
    /*
      hashcode-equals contract:
      1. If two objects are equal, their hashcodes should be equal. Thus, override hashCode() when equals() is overridden.
      2. If two objects are unequal, their hashcodes may not be unequal (because of hashcode collisions).

      In summary, if hashcodes of two objects are the same, it doesn't mean anything. Overridding hashCode() doesn't
      necessitate overriding equals(). A bad hashcode can only mess up the distribution of keys in a Hash collection or map.

      Let's consider the case of a HashMap put. First, hashCode() is calculated to find the right bucket, then equals()
      is called to see if an existing node in the LinkedList should be updated or a new node should be added.
      map.put(k1, v1); // 0x12345 -> k1, v1
      map.put(k2, v2); // 0x12345 -> k1, v1 -> k2, v2 (LinkedList of values, hashCode of k2 collides with that of k1)
      map.put(k1, v'); // 0x12345 -> k1, v' -> k2, v2
     */

    /*
      hashcode      equals      Works?
      --------      ------      ------
      no            no          no (get() and put() have unexpected behavior on hash collections)
      no            yes         no (works with non-hash collections)
      yes           no          yes (a bad hashcode may hamper the distribution of keys in the map)
      yes           yes         yes
     */
    System.out.println("PersonBasic demo");
    {
      Map<PersonBasic, String> m = new HashMap<>();
      final PersonBasic key = new PersonBasic("Saurabh", 100, 5.10);
      m.put(key, "Bangalore");
      System.out.println(m.get(new PersonBasic("Saurabh", 100, 5.10))); // Returns null because objects hashCode is different
      m.put(new PersonBasic("Saurabh", 100, 5.10), "Agra"); //Doesn't replace the key because hashCode is different
      System.out.println(m); // Prints two sets of keys and values
      System.out.println(m.get(key)); // Returns the value because we used the same reference
    }

    System.out.println("\nPersonEquals demo");
    {
      Map<PersonEquals, String> map = new HashMap<>();
      final PersonEquals key = new PersonEquals("Saurabh", 100, 5.10);
      map.put(key, "Bangalore");
      System.out.println(map.get(new PersonEquals("Saurabh", 100, 5.10))); // Returns null because objects hashCode is different
      map.put(new PersonEquals("Saurabh", 100, 5.10), "Agra"); //Doesn't replace the old value because hashCode is different
      System.out.println(map);
      System.out.println(map.get(key)); // Returns the value because we used the same reference
    }

    System.out.println("\nPersonHashCode demo");
    {
      Map<PersonHashCode, String> map = new HashMap<>();
      final PersonHashCode key = new PersonHashCode("Saurabh", 100, 5.10);
      map.put(key, "Bangalore");
      System.out.println(map.get(new PersonHashCode("Saurabh", 100, 5.10))); // Returns null because objects aren't ==
      map.put(new PersonHashCode("Saurabh", 100, 5.10), "Agra"); //Doesn't replace the old value because objects aren't ==
      System.out.println(map);
      System.out.println(map.get(key)); // Returns the value because we used the same reference
    }

    System.out.println("\nPersonHashCodeEquals demo");
    {
      Map<PersonHashCodeEquals, String> map = new HashMap<>();
      final PersonHashCodeEquals key = new PersonHashCodeEquals("Saurabh", 100, 5.10);
      map.put(key, "Bangalore");
      System.out.println(map.get(new PersonHashCodeEquals("Saurabh", 100, 5.10)));
      map.put(new PersonHashCodeEquals("Saurabh", 100, 5.10), "Agra");
      System.out.println(map);
      System.out.println(map.get(key));
    }
  }

  private static class PersonBasic {
    private String name;
    private int age;
    private double height;

    PersonBasic(String name, int age, double height) {
      this.name = name;
      this.age = age;
      this.height = height;
    }

    String getName() {
      return name;
    }

    int getAge() {
      return age;
    }

    double getHeight() {
      return height;
    }

    @Override
    public String toString() {
      return "Name: " + name + " Age: " + age + " Height: " + height;
    }
  }

  private static class PersonHashCode extends PersonBasic {
    public PersonHashCode(String name, int age, double height) {
      super(name, age, height);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getName(), getAge(), getHeight());
    }
  }

  private static class PersonEquals extends PersonBasic {
    public PersonEquals(String name, int age, double height) {
      super(name, age, height);
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }

      if (!(obj instanceof PersonHashCodeEquals)) {
        return false;
      }

      PersonHashCodeEquals other = (PersonHashCodeEquals) obj;
      return other.getName().equals(this.getName()) && other.getAge() == this.getAge() && other.getHeight() == this.getHeight();
    }
  }

  private static class PersonHashCodeEquals extends PersonBasic {
    public PersonHashCodeEquals(String name, int age, double height) {
      super(name, age, height);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getName(), getAge(), getHeight());
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }

      if (!(obj instanceof PersonHashCodeEquals)) {
        return false;
      }

      PersonHashCodeEquals other = (PersonHashCodeEquals) obj;
      return other.getName().equals(this.getName()) && other.getAge() == this.getAge() && other.getHeight() == this.getHeight();
    }
  }
}
