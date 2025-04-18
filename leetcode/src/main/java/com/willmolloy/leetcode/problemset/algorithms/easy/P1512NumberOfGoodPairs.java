package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-good-pairs>https://leetcode.com/problems/number-of-good-pairs/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Brute force it.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1512NumberOfGoodPairs {

  public int numIdenticalPairs(int[] nums) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] == nums[j]) {
          count++;
        }
      }
    }
    return count;
  }
}
