package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/combination-sum-iv>https://leetcode.com/problems/combination-sum-iv/</a>
 *
 * <p>Runtime: O({@code target} * {@code nums.length})
 *
 * <p>Extra memory: O({@code target})
 *
 * <p>Key: Dynamic programming. The recurrence relation is:
 *
 * <ul>
 *   <li>dp[0] = 1
 *   <li>dp[target] = sum(dp[target - num]) for all num : nums
 * </ul>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
interface P377CombinationSum4 {

  int combinationSum4(int[] nums, int target);

  /** Top down (recursive) solution with DP table. */
  class TopDownRecursive implements P377CombinationSum4 {

    @Override
    public int combinationSum4(int[] nums, int target) {
      dp = new int[target + 1];
      Arrays.fill(dp, -1);
      return dfs(nums, target);
    }

    private int[] dp;

    private int dfs(int[] nums, int target) {
      if (target == 0) {
        return 1;
      }
      if (target < 0) {
        return 0;
      }
      if (dp[target] != -1) {
        return dp[target];
      }

      int result = 0;
      for (int num : nums) {
        result += dfs(nums, target - num);
      }

      dp[target] = result;
      return result;
    }
  }

  /** Bottom up (iterative) solution with DP table. */
  class BottomUpDp implements P377CombinationSum4 {

    @Override
    public int combinationSum4(int[] nums, int target) {
      int[] dp = new int[target + 1];
      dp[0] = 1;

      for (int subTarget = 1; subTarget <= target; subTarget++) {
        for (int num : nums) {
          if (subTarget - num >= 0) {
            dp[subTarget] += dp[subTarget - num];
          }
        }
      }
      return dp[target];
    }
  }
}
