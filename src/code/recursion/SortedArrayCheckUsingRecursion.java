package code.recursion;

/**
 * SortedArrayCheckUsingRecursion
 */
public class SortedArrayCheckUsingRecursion {
  public static void main(String[] args) {
    System.out.println("Sorted in ascending order? " + isArraySorted(new int[] { 1, 2, 3, 4, 5 }, 5));
    System.out.println("Sorted in descending order? " + isArraySorted(new int[] { 1, 2, 3, 4, 5 }, 5, SortOrder.DESCENDING));

    System.out.println("Sorted in ascending order? " + isArraySorted(new int[] { 100, 20, 13, 4, -5 }, 5));
    System.out.println("Sorted in descending order? " + isArraySorted(new int[] { 100, 20, 13, 4, -5 }, 5, SortOrder.DESCENDING));

    System.out.println("Sorted? " + isArraySorted(new int[] { 10, 2, 30, 4, 5 }, 5));
    System.out.println("Sorted in ascending order? " + isArraySorted(new int[] { -1, 2, 3, 4, 500, 700, 999 }, 7, SortOrder.ASCENDING));
    System.out.println("Sorted in descending order? " + isArraySorted(new int[] { -1, 2, 3, 4, 500, 700, 999 }, 7, SortOrder.DESCENDING));
  }

  /**
   * Checks if array is sorted in ascending order
   *
   * @param array input array
   * @param size  size of the arr
   * @return true if array is sorted in ascending order
   */
  public static boolean isArraySorted(int[] array, int size) {
    return isArraySorted(array, size, SortOrder.ASCENDING);
  }

  /**
   * Checks if array is sorted in the specified sort order
   *
   * @param array input array
   * @param size  size of the arr
   * @return true if array is sorted in the specified sort order
   */
  public static boolean isArraySorted(int[] array, int size, SortOrder sortOrder) {
    if (size == 1) {
      return true;
    } else if (size < 1) {
      throw new IllegalArgumentException("Array size must be strictly positive");
    }

    switch (sortOrder) {
      case ASCENDING:
        return array[size - 1] > array[size - 2] && isArraySorted(array, size - 1, SortOrder.ASCENDING);
      case DESCENDING:
        return array[size - 1] < array[size - 2] && isArraySorted(array, size - 1, SortOrder.DESCENDING);
      default:
        throw new AssertionError("Unknown SortOrder: " + sortOrder);
    }
  }

  enum SortOrder {
    ASCENDING,
    DESCENDING
  }
}
