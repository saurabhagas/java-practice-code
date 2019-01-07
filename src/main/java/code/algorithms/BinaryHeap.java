package code.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryHeap {
  private final int[] data;

  public BinaryHeap(int[] data) {
    this.data = data.clone();
    convertToHeap();
  }

  public void sort() {
    // One by one extract an element from heap
    for (int i = data.length - 1; i >= 0; i--) {
      // Move current root to end
      swap(0, i);
      // call max heapify on the reduced heap
      heapify(i, 0);
    }
  }

  private void convertToHeap() {
    for (int i = data.length / 2; i >= 0; i--) {
      heapify(data.length, i);
    }
  }

  // To heapify a subtree rooted with node rootIndex which is an index in data[]
  private void heapify(int heapSize, int rootIndex) {
    int largestElementIndex = rootIndex; // Initialize largestElementIndex as root
    int leftChild = 2 * rootIndex + 1;
    int rightChild = 2 * rootIndex + 2;

    // If left child is larger than root
    if (leftChild < heapSize && data[leftChild] > data[largestElementIndex])
      largestElementIndex = leftChild;

    // If right child is larger than largestElementIndex so far
    if (rightChild < heapSize && data[rightChild] > data[largestElementIndex])
      largestElementIndex = rightChild;

    // If largestElementIndex is not root
    if (largestElementIndex != rootIndex) {
      swap(rootIndex, largestElementIndex);
      // Recursively heapify the affected sub-tree
      heapify(heapSize, largestElementIndex);
    }
  }

  private void swap(int one, int two) {
    int swap = data[one];
    data[one] = data[two];
    data[two] = swap;
  }

  @Override
  public String toString() {
    return Arrays.stream(data).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  public static void main(String[] args) {
    int[] data = {12, 11, 13, 5, 6, 7};
    BinaryHeap binaryHeap = new BinaryHeap(data);
    System.out.println("Binary heap is: " + binaryHeap);
    binaryHeap.sort();
    System.out.println("Sorted dataay is: " + binaryHeap);
  }
}
