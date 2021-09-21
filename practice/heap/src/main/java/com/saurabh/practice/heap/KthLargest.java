package com.saurabh.practice.heap;

import java.util.PriorityQueue;

public class KthLargest {
  private final PriorityQueue<Integer> topK;
  private final int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    topK = new PriorityQueue<>();
    for (int num : nums) {
      add(num);
    }
  }

  public int add(int val) {
    if (topK.size() < k) {
      topK.offer(val);
    } else if (val > topK.peek()) {
      topK.poll(); // remove smallest element
      topK.offer(val);
    }

    return topK.peek();
  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 8, 2}; // 2, 4, 5, 8
    KthLargest kthLargest = new KthLargest(3, nums);
    System.out.println("kthLargest.add(3) = " + kthLargest.add(3));
    System.out.println("kthLargest.add(5) = " + kthLargest.add(5));
    System.out.println("kthLargest.add(10) = " + kthLargest.add(10));
    System.out.println("kthLargest.add(9) = " + kthLargest.add(9));
    System.out.println("kthLargest.add(4) = " + kthLargest.add(4));
  }
}
