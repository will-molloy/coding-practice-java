package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a href=https://leetcode.com/problems/target-sum>https://leetcode.com/problems/target-sum/</a>
 *
 * <p>Runtime: O(2<sup>n</sup>)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Sequence forms a binary tree.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P784LetterCasePermutation
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P494TargetSum {

  // TODO O(n) solution is possible! Thought that n <= 20 would be fine for exponential solution.

  private int count;

  public int findTargetSumWays(int[] nums, int target) {
    count = 0;
    dfs(nums, target, 0, 0);
    return count;
  }

  void dfs(int[] nums, int target, int sum, int i) {
    if (i == nums.length) {
      if (sum == target) {
        count++;
      }
      return;
    }

    dfs(nums, target, sum + nums[i], i + 1);
    dfs(nums, target, sum - nums[i], i + 1);
  }
}
