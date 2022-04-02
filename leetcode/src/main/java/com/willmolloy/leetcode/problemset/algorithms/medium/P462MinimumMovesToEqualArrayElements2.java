package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii>https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Meet at (any) median. More of a math problem than coding.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P453MinimumMovesToEqualArrayElements
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P462MinimumMovesToEqualArrayElements2 {

  public int minMoves2(int[] nums) {
    Arrays.sort(nums);

    int median = nums[nums.length / 2];
    int sum = 0;
    for (int num : nums) {
      sum += Math.abs(num - median);
    }
    return sum;
  }
}
