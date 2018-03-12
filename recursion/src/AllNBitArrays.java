/**
 * Program to generate all possible combinations of an n-bit array
 */
public class AllNBitArrays {
  public static void main(String[] args) {
    generateNBitArrayCombinations(new int[3], 3);
//    generateNBitArrayCombinations(new int[5], 5);
  }

  /**
   * Recursively generates all possible combinations of the n bits. Divides the problem into two parts:
   * <ol>
   * <li>Set the nth bit to 0 and recurse</li>
   * <li>Set the nth bit to 1 and recurse</li>
   * </ol>
   *
   * @param array allocated array of size n (initially empty)
   * @param n     size of the input array
   */
  public static void generateNBitArrayCombinations(int[] array, int n) {
    if (n == 0) {
      for (int item : array) {
        System.out.print(item + " ");
      }
      System.out.println();
      return;
    }

    array[n - 1] = 0;
    generateNBitArrayCombinations(array, n - 1);

    array[n - 1] = 1;
    generateNBitArrayCombinations(array, n - 1);
  }
}
