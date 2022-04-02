package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a href=https://leetcode.com/problems/powx-n>https://leetcode.com/problems/powx-n</a>
 *
 * <p>Key: knowledge of math, recursion, memoization of sub problem solution, ultimately dp
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P50PowXn {

  double myPow(double x, int n);

  /**
   * Naive linear recursive solution.
   *
   * <p>Stackoverflow on leetcode, maybe pass with loop/tail recursion.
   *
   * <p>Runtime: O(n)
   */
  class LinearRecursive implements P50PowXn {

    public double myPow(double x, int n) {
      // known cases
      if (n == 0) {
        return 1;
      }
      if (n == 1) {
        return x;
      }

      if (n < 0) {
        // if negative power, then flip
        return 1 / myPow(x, -n);
      }

      // recursive case
      return x * myPow(x, n - 1);
    }
  }

  /**
   * Log (base2) recursive solution.
   *
   * <p>This time divide n by 2 rather than subtract 1; fewer computations and hence fewer stack
   * frames.
   *
   * <p>Runtime: O(lg(n))
   */
  class Log2Recursive implements P50PowXn {

    public double myPow(double x, int n) {
      // known cases
      if (n == 0) {
        return 1;
      }
      if (n == 1) {
        return x;
      }

      if (n < 0 && n != Integer.MIN_VALUE) {
        // if negative power, then flip
        // note Integer.MIN_VALUE is a special case:
        // -Integer.MIN_VALUE is itself, so will infinitely recurse
        // instead must treat as positive value which somehow works out TODO ???
        return 1 / myPow(x, -n);
      }

      // use temp variable to cache sub problem solution
      double temp = myPow(x, n / 2);
      if (n % 2 == 0) {
        // even power
        return temp * temp;
      } else {
        // odd power, since integer divide also floors, has extra x
        return x * temp * temp;
      }
    }
  }
}
