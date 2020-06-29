package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/single-number>https://leetcode.com/problems/single-number</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: bitwise operators
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P137SingleNumber2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P136SingleNumber {

  public int singleNumber(int[] nums) {
    return Arrays.stream(nums).reduce(0, this::xor);
  }

  private int xor(int a, int b) {
    return a ^ b;
  }
}
