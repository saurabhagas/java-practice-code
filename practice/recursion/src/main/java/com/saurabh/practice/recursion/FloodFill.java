package com.saurabh.practice.recursion;

import java.util.Arrays;

/*
  Problem: Given a coordinate (x, y) representing the starting pixel (row and column) of the flood fill, and a pixel
  value newColor, "flood fill" the image. Taken from: https://leetcode.com/problems/flood-fill/.
  Approach:
  Complexity: O(nm)
 */
public class FloodFill {
  public static void main(String[] args) {
    FloodFill obj = new FloodFill();
    int[][] image = {
        {1, 1, 1, 1, 1, 1},
        {1, 1, 2, 2, 1, 1},
        {1, 1, 2, 2, 1, 1},
        {2, 1, 2, 2, 1, 2},
    };
    System.out.println(Arrays.deepToString(obj.floodFill(image, 2, 2, 100)));
  }

  public int[][] floodFill(int[][] image, int x, int y, int newColor) {
    floodFill(image, x, y, image[x][y], newColor);
    return image;
  }

  public void floodFill(int[][] image, int x, int y, int prevColor, int newColor) {
    if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) return; // Out-of-bounds
    if (image[x][y] != prevColor) return; // Wrong cell

    image[x][y] = newColor;
    floodFill(image, x - 1, y, prevColor, newColor);
    floodFill(image, x + 1, y, prevColor, newColor);
    floodFill(image, x, y - 1, prevColor, newColor);
    floodFill(image, x, y + 1, prevColor, newColor);
  }
}
