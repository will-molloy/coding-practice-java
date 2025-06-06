package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href=https://leetcode.com/problems/house-robber>https://leetcode.com/problems/house-robber</a>
 *
 * <p>Key idea: dynamic programming
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P213HouseRobber2
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P337HouseRobber3
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P198HouseRobber {

  int rob(int[] nums);

  /**
   * Top down solution; uses memoization cache to filter duplicate work.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n)
   */
  final class TopDown implements P198HouseRobber {

    @Override
    public int rob(int[] nums) {
      return rob(asList(nums), new HashMap<>());
    }

    private int rob(List<Integer> nums, Map<List<Integer>, Integer> cache) {
      // base cases
      if (nums.isEmpty()) {
        return 0;
      }
      if (nums.size() == 1) {
        return nums.getFirst();
      }
      if (nums.size() == 2) {
        return Math.max(nums.get(0), nums.get(1));
      }
      if (nums.size() == 3) {
        return Math.max(nums.get(0) + nums.get(2), nums.get(1));
      }

      Integer result = cache.get(nums);
      if (result != null) {
        return result;
      }

      // recursive case
      int takeHead = nums.get(0) + rob(nums.subList(2, nums.size()), cache);
      int skipHead = nums.get(1) + rob(nums.subList(3, nums.size()), cache);
      result = Math.max(takeHead, skipHead);
      cache.put(nums, result);
      return result;
    }

    private static List<Integer> asList(int[] nums) {
      return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
  }

  /**
   * Bottom up solution; uses 1d array to build up solutions.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n)
   */
  final class BottomUp implements P198HouseRobber {

    @Override
    public int rob(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }

      int[] dp = new int[nums.length + 1];
      dp[0] = 0;
      dp[1] = nums[0];

      for (int i = 1; i < nums.length; i += 1) {
        int take = nums[i] + dp[i - 1];
        int skip = dp[i];
        dp[i + 1] = Math.max(take, skip);
      }
      return dp[nums.length];
    }
  }

  /**
   * Bottom up solution; uses constant number of variables to build up solutions. (In the previous
   * approach ({@link BottomUp#rob}) we only needed at most 2 previous solutions.)
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   */
  final class BottomUpConstantSpace implements P198HouseRobber {

    @Override
    public int rob(int[] nums) {
      if (nums.length == 0) {
        return 0;
      }

      int dpIMinus1 = 0; // dp[i - 1]
      int dp = nums[0]; // dp[i]

      for (int i = 1; i < nums.length; i++) {
        int take = nums[i] + dpIMinus1;
        int skip = dp;
        int dpIPlus1 = Math.max(take, skip);
        // swap
        int temp = dp;
        dp = dpIPlus1;
        dpIMinus1 = temp;
      }
      return dp; // dp[n]
    }
  }
}
