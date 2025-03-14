package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/longest-mountain-in-array>https://leetcode.com/problems/longest-mountain-in-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: 3 ways the line can go: up, down, or flat. Up followed by down is a mountain.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P845LongestMountainInArray {

  public int longestMountain(int[] a) {
    int n = a.length;
    int max = 0;

    // 3 ways the line can go
    // 1. up
    // 2. down
    // 3. flat

    int i = 0;
    while (i + 1 < n) {
      boolean up = false;
      boolean down = false;
      int start = i;

      // traverse up
      while (i + 1 < n && a[i] < a[i + 1]) {
        i++;
        up = true;
      }
      // traverse down (if preceded by up)
      while (up && i + 1 < n && a[i] > a[i + 1]) {
        i++;
        down = true;
      }

      if (up && down) {
        max = Math.max(max, i - start + 1);
      }

      // move i forward by 1 if it didn't change (i.e. when flat or down without up)
      i = i == start ? start + 1 : i;
    }
    return max;
  }
}
