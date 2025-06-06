package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/n-th-tribonacci-number>https://leetcode.com/problems/n-th-tribonacci-number</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: dynamic programming
 *
 * @see P509FibonacciNumber
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1137NthTribonacciNumber {

  public int tribonacci(int n) {
    // assumed n >= 0
    if (n == 0 || n == 1) {
      return n;
    }

    // n >= 2 at this point
    int tnMinus2 = 0;
    int tnMinus1 = 1;
    int tn = 1;

    for (int i = 3; i <= n; i++) {
      int tempTn = tn;
      int tempTnMinus1 = tnMinus1;

      tn = tn + tnMinus1 + tnMinus2;
      tnMinus1 = tempTn;
      tnMinus2 = tempTnMinus1;
    }

    return tn;
  }
}
