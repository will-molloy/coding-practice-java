package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/get-maximum-in-generated-array>https://leetcode.com/problems/get-maximum-in-generated-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Generate array as described.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1646GetMaximumInGeneratedArray {

  public int getMaximumGenerated(int n) {
    if (n == 0) {
      return 0;
    }

    int[] nums = new int[n + 1];
    nums[0] = 0;
    nums[1] = 1;

    int max = 1;
    for (int i = 2; i < nums.length; i++) {
      if (i % 2 == 0) {
        nums[i] = nums[i / 2];
      } else {
        nums[i] = nums[i / 2] + nums[i / 2 + 1];
      }
      max = Math.max(max, nums[i]);
    }
    return max;
  }
}
