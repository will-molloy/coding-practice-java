package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/single-number>https://leetcode.com/problems/single-number</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: bitwise operators
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P137SingleNumber2
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P260SingleNumber3
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P136SingleNumber {

  public int singleNumber(int[] nums) {
    return Arrays.stream(nums).reduce(0, this::xor);
  }

  private int xor(int a, int b) {
    return a ^ b;
  }
}
