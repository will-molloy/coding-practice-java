package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/divide-two-integers>https://leetcode.com/problems/divide-two-integers</a>
 *
 * <p>Runtime: TODO O()
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P29DivideTwoIntegers {

  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      // overflow case
      return Integer.MAX_VALUE;
    }
    return dividend / divisor;
  }
}
