package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/power-of-four>https://leetcode.com/problems/power-of-four/</a>
 *
 * <p>Runtime: O(log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Divide by 4 until 1, at each step check divisible by 4.
 *
 * @see P231PowerOfTwo
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P342PowerOfFour {

  // TODO Follow up: Could you solve it without loops/recursion?

  public boolean isPowerOfFour(int num) {
    while (num > 1) {
      if (num % 4 != 0) {
        return false;
      }
      num /= 4;
    }
    return num == 1;
  }
}
