package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/flipping-an-image>https://leetcode.com/problems/flipping-an-image/</a>
 *
 * <p>Runtime: O(n) (n - number of cells)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Not really a problem, just do what is asked.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P832FlippingAnImage {

  public int[][] flipAndInvertImage(int[][] a) {
    for (int[] b : a) {
      reverse(b);
      for (int i = 0; i < b.length; i++) {
        b[i] = b[i] == 0 ? 1 : 0;
      }
    }
    return a;
  }

  private void reverse(int[] a) {
    int l = 0;
    int r = a.length - 1;
    while (l < r) {
      swap(a, l++, r--);
    }
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
