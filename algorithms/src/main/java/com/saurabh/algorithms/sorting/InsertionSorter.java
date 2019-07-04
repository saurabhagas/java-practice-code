package com.saurabh.algorithms.sorting;

import java.util.Comparator;
import java.util.Objects;

/**
 * Insertion Sorter Algorithm
 * Starts from first two elements, sorts them, further selecting next elements and inserting them into this sorted sub-array.
 * Property: If number of elements is smaller, it works even better than Merge and Quick sort
 * Time Complexity -
 * Worst Case: O(n^2)     => All elements in reverse order
 * Average Case: O(n^2)
 * Best Case: O(n)        => All elements in proper order
 */

public class InsertionSorter<T extends Comparable> implements Sorter<T> {
  public T[] sort(T[] items) {
    Objects.requireNonNull(items);

    for (int i = 1; i < items.length; i++) {
      // Get the element after the sub-items ends
      T temp = items[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        // Compare the end element with sorted sub-items iterating from the largest element of sub-items(end index of sub-items) to smaller ones
        // And then stop iterating after the end element is larger than the selected element of the sub-items
        if (temp.compareTo(items[j]) <= 0) {
          //Shift the larger elements of sub-items to next position (last position is the 'temp' variable position or index 'i')
          items[j + 1] = items[j];
        } else {
          break;
        }
      }
      // Insert the end element to the sorted items. Now the sorted items grows in size.
      items[j + 1] = temp;
    }
    return items;
  }

  @Override
  public Object[] sort(Object[] items, Comparator comparator) {
    Objects.requireNonNull(items);

    for (int i = 1; i < items.length; i++) {
      // Get the element after the sub-items ends
      Object temp = items[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        // Compare the end element with sorted sub-items iterating from the largest element of sub-items(end index of sub-items) to smaller ones
        // And then stop iterating after the end element is larger than the selected element of the sub-items
        if (comparator.compare(temp, items[j]) <= 0) {
          //Shift the larger elements of sub-items to next position (last position is the 'temp' variable position or index 'i')
          items[j + 1] = items[j];
        } else {
          break;
        }
      }
      // Insert the end element to the sorted items. Now the sorted items grows in size.
      items[j + 1] = temp;
    }
    return items;
  }
}
