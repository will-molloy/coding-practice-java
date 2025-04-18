package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/valid-perfect-square>https://leetcode.com/problems/valid-perfect-square/</a>
 *
 * <p>Runtime: O(log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Searching a sequence ([1, num]) so use binary search.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P367ValidPerfectSquare {

  // TODO newton's method (math knowledge...) which is O(1)

  public boolean isPerfectSquare(int num) {
    long l = 1;
    long h = num;
    while (l <= h) {
      long mid = l + (h - l) / 2;
      if (mid * mid == num) {
        return true;
      }
      if (mid * mid < num) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return false;
  }
}
