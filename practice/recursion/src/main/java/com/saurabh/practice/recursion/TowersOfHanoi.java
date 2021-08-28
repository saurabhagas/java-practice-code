package com.saurabh.practice.recursion;

/**
 * Class that solves the classic Towers of Hanoi problem.
 * Runtime: O(2^n)
 */
class TowersOfHanoi {
  public static void main(String[] args) {
    TowersOfHanoi towers = new TowersOfHanoi();
    towers.solve(3, 'A', 'C', 'B');
//    towers.solve(4, 'A', 'C', 'B');
//    towers.solve(5, 'A', 'C', 'B');
  }

  public void solve(int disks, char source, char destination, char auxiliary) {
    if (disks == 0) return;
    solve(disks - 1, source, auxiliary, destination);
    System.out.println("Move disk: " + disks + " from: " + source + " to: " + destination);
    solve(disks - 1, auxiliary, destination, source);
  }
}