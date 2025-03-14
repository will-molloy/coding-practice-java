package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/partition-equal-subset-sum>https://leetcode.com/problems/partition-equal-subset-sum/</a>
 *
 * <p>Runtime: O(n * m) (n - {@code nums.length}, m = sum({@code nums}))
 *
 * <p>Extra memory: O(m * n)
 *
 * <p>Key idea: Variant of knapsack problem (dynamic programming). Determine if proper subset which
 * sums to sum({@code nums})/2 exists (as other elements must sum to the same thing...).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P416PartitionEqualSubsetSum {

  private Map<Integer, Map<Integer, Boolean>> dp;

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    int half = sum / 2;
    dp = new HashMap<>();

    return f(nums, 0, 0, half);
  }

  private boolean f(int[] nums, int i, int sum, int target) {
    // base cases
    if (sum == target) {
      // reached target
      return true;
    }
    if (i == nums.length - 1 || sum > target) {
      // reached final element (no longer proper subset if we consider it) (don't need to care about
      // it as we indirectly consider it in the other partition)
      // OR went beyond target
      return false;
    }

    // check if already computed
    if (dp.containsKey(i) && dp.get(i).containsKey(sum)) {
      return dp.get(i).get(sum);
    }

    // recursive case
    // either take or skip nums[i]
    boolean v = f(nums, i + 1, sum + nums[i], target) || f(nums, i + 1, sum, target);
    dp.computeIfAbsent(i, k -> new HashMap<>()).put(sum, v);
    return v;
  }
}
