package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/the-kth-factor-of-n>https://leetcode.com/problems/the-kth-factor-of-n/</a>
 *
 * <p>Runtime: O(sqrt(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Factors are in [1, n] and can be partitioned into those before sqrt(n) and those
 * after. First loop [1, sqrt(n)), then loop [sqrt(n), n] (via [sqrt(n), 1] - so return n/i).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1492TheKthFactorOfN {

  public int kthFactor(int n, int k) {
    // [1, sqrt(n))
    for (int i = 1; i * i < n; i++) {
      if (n % i == 0) {
        k--;
        if (k == 0) {
          return i;
        }
      }
    }

    // [sqrt(n), n] (via [sqrt(n), 1] - so return n/i)
    for (int i = (int) Math.sqrt(n); i >= 1; i--) {
      if (n % i == 0) {
        k--;
        if (k == 0) {
          return n / i;
        }
      }
    }
    return -1;
  }
}
