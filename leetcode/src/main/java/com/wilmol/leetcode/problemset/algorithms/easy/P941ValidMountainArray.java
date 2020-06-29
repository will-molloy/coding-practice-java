package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/valid-mountain-array>https://leetcode.com/problems/valid-mountain-array/</a>
 *
 * <p>Runtime: O(n) (one pass)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Separate loops for climb and descent.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P941ValidMountainArray {

  public boolean validMountainArray(int[] a) {
    int n = a.length;
    if (n < 3) {
      return false;
    }

    // climb mountain until it stops increasing
    int i = 0;
    while (i + 1 < n && a[i] < a[i + 1]) {
      i++;
    }

    // peak can't be first or last
    if (i == 0 || i == n - 1) {
      return false;
    }

    // ensure descent is strictly decreasing
    while (i + 1 < n) {
      if (a[i] <= a[i + 1]) {
        return false;
      }
      i++;
    }
    return true;
  }
}
