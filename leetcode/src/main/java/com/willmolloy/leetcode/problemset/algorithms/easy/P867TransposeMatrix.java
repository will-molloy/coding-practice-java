package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/transpose-matrix>https://leetcode.com/problems/transpose-matrix/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(nm)
 *
 * <p>Space: O(nm) (O(1) if returned array is excluded here)
 *
 * <p>Key: Linear algebra.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P867TransposeMatrix {

  public int[][] transpose(int[][] a) {
    int n = a.length;
    if (n == 0) {
      return a;
    }
    int m = a[0].length;

    int[][] t = new int[m][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        t[j][i] = a[i][j];
      }
    }
    return t;
  }
}
