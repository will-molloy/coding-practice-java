package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-08-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/divide-two-integers>https://leetcode.com/problems/divide-two-integers</a>
 *
 * <p>Runtime: TODO O()
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
