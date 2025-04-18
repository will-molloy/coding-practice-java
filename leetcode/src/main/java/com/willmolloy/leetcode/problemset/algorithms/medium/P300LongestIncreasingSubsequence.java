package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/longest-increasing-subsequence>https://leetcode.com/problems/longest-increasing-subsequence</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: Return the max not dp[n-1].
 *
 * @see <a href=https://youtu.be/fV-TF4OvZpk>Back To Back SWE's video</a>
 * @see P368LargestDivisibleSubset
 * @see P673NumberOfLongestIncreasingSubsequence
 * @see P873LengthOfLongestFibonacciSequence
 * @see P1626BestTeamWithNoConflicts
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P354RussianDollEnvelopes
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P300LongestIncreasingSubsequence {

  // TODO O(n log n) time solution

  public int lengthOfLis(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    // dp[i] = length of longest increasing subsequence ending with nums[i]
    // i.e. only considers nums[0, i] (subsequence must be sequential)
    int[] dp = new int[nums.length];

    // base case:
    // length of singleton subsequences (individual elements) is 1
    Arrays.fill(dp, 1);

    // recursive case:
    // solve dp[i] for all i : [1, n) (already solved dp[0])
    for (int i = 1; i < nums.length; i++) {
      // try all j < i (subsequence must be sequential)
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          // nums[i] can extend the longest increasing subsequence ending with nums[j]
          // update maximum length of longest increasing subsequence ending with nums[i]
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int max = 1;
    for (int i : dp) {
      max = Math.max(max, i);
    }
    return max;
  }
}
