package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array>https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) TODO O(n) is possible
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Try all pairs.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P421MaximumXorOfTwoNumbersInAnArray {

  public int findMaximumXor(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        max = Math.max(nums[i] ^ nums[j], max);
      }
    }
    return max;
  }
}
