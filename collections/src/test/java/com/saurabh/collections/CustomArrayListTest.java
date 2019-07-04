package com.saurabh.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class CustomArrayListTest {
  private CustomArrayListImpl<String> customArrayList;

  @Before
  public void init() {
    customArrayList = new CustomArrayListImpl<>();
    customArrayList.add("abc1");
    customArrayList.add("abc2");
    customArrayList.add("abc3");
    customArrayList.add("abc4");
    customArrayList.add("abc5");
    customArrayList.add("abc6");
    customArrayList.add("abc7");
    customArrayList.add("abc8");
    customArrayList.add("abc9");
  }

  @Test
  public void checkArrayExpansionAfterAdd() {
    customArrayList.add("abc10");
    customArrayList.add("abc11");
    assertThat(customArrayList.getCapacity()).isEqualTo(20);
    assertThat(customArrayList.size()).isEqualTo(11);

  }

  @Test
  public void printCustomArrayList() {
    assertThat(customArrayList.toString()).isEqualTo("[abc1, abc2, abc3, abc4, abc5, abc6, abc7, abc8, abc9]");
  }

  @Test
  public void setElementAtIndex() {
    customArrayList.set(5, "abc66");
    assertThat(customArrayList.get(5)).isEqualTo("abc66");
  }

  @Test
  public void removeElementAtIndex() {
    String removedItem = customArrayList.remove(4);
    assertThat(removedItem).isEqualTo("abc5");
    assertThat(customArrayList.size()).isEqualTo(8);
    assertThat(customArrayList.toString()).isEqualTo("[abc1, abc2, abc3, abc4, abc6, abc7, abc8, abc9]");
  }

  @Test
  public void removeElementByContent() {
    boolean removedItem = customArrayList.remove("abc6");
    assertThat(removedItem).isTrue();
    assertThat(customArrayList.size()).isEqualTo(8);
  }

  @Test
  public void addArrayList() {
    ArrayList<String> newList = new ArrayList<>();
    newList.add("xyz1");
    newList.add("xyz2");
    newList.add("xyz3");
    newList.add("xyz4");
    customArrayList.addAll(newList);
    assertThat(customArrayList.size()).isEqualTo(13);
    assertThat(customArrayList.toString()).isEqualTo("[abc1, abc2, abc3, abc4, abc5, abc6, abc7, abc8, abc9, xyz1, xyz2, xyz3, xyz4]");
  }

  @Test
  public void clearListElements() {
    customArrayList.clear();
    assertThat(customArrayList.toString()).isEqualTo("[]");
    assertThat(customArrayList.size()).isEqualTo(0);
    assertThat(customArrayList.isEmpty()).isTrue();
  }

  @Test
  public void addNull() {
    assertThatNullPointerException().isThrownBy(() -> customArrayList.add(null));
  }

  @Test
  public void setNull() {
    assertThatNullPointerException().isThrownBy(() -> customArrayList.set(5, null));
  }

  @Test
  public void removeElementAtInvalidIndex() {
    assertThatThrownBy(() -> customArrayList.remove(20)).hasMessage("Specified index 20 is out of bounds of the size 9 of the list");
  }

  @Test
  public void removeInvalidElement() {
    assertThat(customArrayList.remove("xyz")).isFalse();
  }

  @Test
  public void removeAllTest() {
    ArrayList<String> newList = new ArrayList<>();
    newList.add("abc5");
    newList.add("abc8");
    newList.add("abc3");
    newList.add("abc20");
    customArrayList.removeAll(newList);
    assertThat(customArrayList.toString()).isEqualTo("[abc1, abc2, abc4, abc6, abc7, abc9]");
    assertThat(customArrayList.size()).isEqualTo(6);
  }

  @Test
  public void removeElementToCheckArrayShrink() {
    customArrayList.add("xyz1");
    customArrayList.add("xyz2");
    customArrayList.add("xyz3");
    customArrayList.add("xyz4");
    assertThat(customArrayList.toString()).isEqualTo("[abc1, abc2, abc3, abc4, abc5, abc6, abc7, abc8, abc9, xyz1, xyz2, xyz3, xyz4]");
    assertThat(customArrayList.size()).isEqualTo(13);
    assertThat(customArrayList.getCapacity()).isEqualTo(20);
    customArrayList.remove(0);
    customArrayList.remove(0);
    customArrayList.remove(0);
    assertThat(customArrayList.toString()).isEqualTo("[abc4, abc5, abc6, abc7, abc8, abc9, xyz1, xyz2, xyz3, xyz4]");
    assertThat(customArrayList.size()).isEqualTo(10);
    assertThat(customArrayList.getCapacity()).isEqualTo(10);
  }

  @Test
  public void testIterator() {
    Iterator<String> iterator = customArrayList.iterator();
    int i = 1;
    while (iterator.hasNext()) {
      String nextItem = iterator.next();
      assertThat(nextItem).isNotNull();
      assertThat(nextItem).isEqualTo("abc" + i);
      i++;
    }
    assertThatThrownBy(iterator::next).hasMessage("There is no element in the List at this position");
  }

  @Test
  public void testContains() {
    boolean containsResult = customArrayList.contains("abc1");
    assertThat(containsResult).isTrue();
    boolean containsResult1 = customArrayList.contains("pqr");
    assertThat(containsResult1).isFalse();
  }

  @Test
  public void testContainsAll() {
    ArrayList<String> newList = new ArrayList<>();
    newList.add("abc5");
    newList.add("abc8");
    newList.add("abc3");
    newList.add("abc20");
    boolean result = customArrayList.containsAll(newList);
    assertThat(result).isFalse();
  }

  @Test
  public void retainAllTest() {
    ArrayList<String> newList = new ArrayList<>();
    newList.add("abc5");
    newList.add("abc8");
    newList.add("abc3");
    newList.add("abc20");
    boolean result = customArrayList.retainAll(newList);
    assertThat(result).isTrue();
    assertThat(customArrayList.toString()).isEqualTo("[abc3, abc5, abc8]");
    assertThat(customArrayList.size()).isEqualTo(3);
  }

  @Test
  public void toArrayTestObject() {
    Object[] array = customArrayList.toArray();
    int i = 1;
    for (Object o : array) {
      assertThat(o).isEqualTo("abc" + i);
      i++;
    }
  }

  @Test
  public void toArrayTest() {
    String[] array = new String[customArrayList.size()];
    array = customArrayList.toArray(array);
    int i = 1;
    for (String o : array) {
      assertThat(o).isEqualTo("abc" + i);
      i++;
    }
  }

  @Test
  public void toArrayTest_sourceSizeSmaller() {
    String[] array = new String[0];
    array = customArrayList.toArray(array);
    int i = 1;
    for (String o : array) {
      assertThat(o).isEqualTo("abc" + i);
      i++;
    }
  }
}
