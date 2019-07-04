package code.algorithms.test;

public class CustomInt implements Comparable {
  private Integer element;

  CustomInt(Integer element) {
    this.element = element;
  }

  @Override
  public int compareTo(Object o) {
    CustomInt obj = (CustomInt) o;
    return this.element.compareTo(obj.element);
  }
}
