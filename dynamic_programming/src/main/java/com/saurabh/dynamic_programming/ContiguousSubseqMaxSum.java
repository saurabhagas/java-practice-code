package com.saurabh.dynamic_programming;

public class ContiguousSubseqMaxSum {

  public int[] contiguousSubseqMaxSum(int[] a) {

    if(a == null) {
      return null;
    }
    int[] L = new int[a.length];
    int n = a.length;
    if(n != 0) {
      L[0] = a[0];
      for (int i = 1; i < n; i++) {
        L[i] = a[i] + Math.max(0, L[i - 1]);
      }
    }
    return L;
  }

}
