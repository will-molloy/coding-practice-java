package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a href=https://leetcode.com/problems/132-pattern>https://leetcode.com/problems/132-pattern/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) TODO can do O(n log(n)) or even O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Tracking lower bound ({@code minSoFar}).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P456132Pattern {

  public boolean find132pattern(int[] a) {
    int n = a.length;
    if (n < 3) {
      return false;
    }

    // track a[i] as minSoFar so cut down from cubic to quadratic time
    int minSoFar = Integer.MAX_VALUE;
    for (int j = 0; j < n - 1; j++) {
      minSoFar = Math.min(minSoFar, a[j]);
      for (int k = j + 1; k < n; k++) {
        if (minSoFar < a[k] && a[k] < a[j]) {
          return true;
        }
      }
    }
    return false;
  }
}
