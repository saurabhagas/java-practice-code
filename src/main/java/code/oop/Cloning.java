package code.oop;

public class Cloning {
  public static void main(String[] args) throws Exception {
    //Assigning reference variables
    Sample first = new Sample();
    Sample second = first;
    first.name = "Saurabh";
    System.out.println("Cloning using reference assignment");
    System.out.println(first);
    System.out.println(second);

    //Use of Object::clone
    first = new Sample();
    second = first.clone();
    first.address.append(" address");
    System.out.println("\nCloning using Object::clone");
    System.out.println(first);
    System.out.println(second);

    //Copy constructor
    first = new Sample();
    second = new Sample(first);
    first.name = "Saurabh";
    System.out.println("\nCloning using copy constructor");
    System.out.println(first);
    System.out.println(second);

    //Factory method
    first = new Sample();
    second = Sample.copy(first);
    first.address.append(" address");
    System.out.println("\nCloning using factory method");
    System.out.println(first);
    System.out.println(second);
  }

  private static class Sample implements Cloneable {
    int age;
    String name;
    final StringBuilder address;

    Sample() {
      this.age = 10;
      this.name = "SomeDude";
      this.address = new StringBuilder("Sample");
    }

    Sample(Sample old) {
      this.age = old.age;
      this.name = old.name;
      this.address = new StringBuilder(old.address); //Need to use defensive copying because StringBuilder is mutable
    }

    @Override
    public Sample clone() throws CloneNotSupportedException {
      //Does shallow copy. To do it correctly, copy mutable objects manually, or simply delegate to copy constructor
      return (Sample) super.clone();
    }

    static Sample copy(Sample old) {
      return new Sample(old); //Piggyback on to copy constructor
    }

    @Override
    public String toString() {
      return "Sample{" +
          "age=" + age +
          ", name='" + name + '\'' +
          ", address=" + address +
          '}';
    }
  }
}
