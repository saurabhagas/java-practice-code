package code.collections.custom.impl;

import java.util.Arrays;

/**
 * TwoStacksInOneArray
 */
public class TwoStacksInOneArray {
  private static class TwoStacks {
    private final int size;
    private final int[] array;
    private int leftStackHeadPosition;
    private int rightStackHeadPosition;

    public TwoStacks(int size) {
      this.size = size;
      this.array = new int[size];
      leftStackHeadPosition = -1;
      rightStackHeadPosition = size;
    }

    public boolean push1(int item) {
      if (leftStackHeadPosition == rightStackHeadPosition) {
        return false;
      }
      array[++leftStackHeadPosition] = item;
      return true;
    }

    public boolean push2(int item) {
      if (leftStackHeadPosition == rightStackHeadPosition) {
        return false;
      }
      array[--rightStackHeadPosition] = item;
      return true;
    }

    public int pop1() {
      if (leftStackHeadPosition == -1) {
        throw new IllegalStateException();
      }
      return array[leftStackHeadPosition--];
    }

    public int pop2() {
      if (rightStackHeadPosition == size) {
        throw new IllegalStateException();
      }
      return array[rightStackHeadPosition++];
    }

    @Override
    public String toString() {
      return Arrays.toString(array);
    }
  }

  public static void main(String[] args) {
    TwoStacks tS = new TwoStacks(5);

    tS.push1(11);
    tS.push1(3);
    tS.push1(7);
    tS.push2(1);
    tS.push2(9);
    System.out.println(tS);

    System.out.println(tS.pop1());
    System.out.println(tS.pop2());
    System.out.println(tS.pop2());
    System.out.println(tS.pop1());
    System.out.println(tS.pop1());
  }
}
