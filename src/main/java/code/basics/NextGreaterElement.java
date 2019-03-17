package code.basics;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class NextGreaterElement {
  public static int[] nextGreaterElement(int[] arr) {
    int[] resultArray = IntStream.generate(() -> -1).limit(arr.length).toArray();
    int resultArrayIndex = -1;
    Deque<Integer> smallerElements = new ArrayDeque<>();

    smallerElements.push(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      int currentArrayElement = arr[i];
      if (!smallerElements.isEmpty()) {
        int poppedElement = smallerElements.peek();
        while (poppedElement < currentArrayElement) {
          smallerElements.pop();
          // currentArrayElement is the NGE, save it in results array
          resultArray[++resultArrayIndex] = currentArrayElement;
          if (smallerElements.isEmpty()) {
            break;
          }
          poppedElement = smallerElements.peek();
        }
      }
      smallerElements.push(currentArrayElement);
    }
    return resultArray;
  }

  public static void main(String[] args) {
    int[] arr = {4, 6, 3, 2, 8, 1, 9, 9, 9};
    System.out.println("Original : " + Arrays.toString(arr));
    System.out.println("NGE array: " + Arrays.toString(nextGreaterElement(arr)));
  }
}