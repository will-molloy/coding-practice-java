package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a
 * href=https://leetcode.com/problems/russian-doll-envelopes>https://leetcode.com/problems/russian-doll-envelopes/</a>
 *
 * <p>Runtime: O(n * log(n)) + lis algorithm
 *
 * <p>Extra memory: O(n) + lis algorithm
 *
 * <p>Key idea: Longest increasing subsequence in 2 dimensions.
 *
 * <p>First sort by width/height (calling here the 'former') ascending so its trivially increasing.
 *
 * <p>Then sort by the latter descending so when there are ties on the former, only one from the
 * latter is taken, as the others are blocked in the lis algorithm by the larger value.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P300LongestIncreasingSubsequence
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P354RussianDollEnvelopes {

  public int maxEnvelopes(int[][] envelopes) {
    int[] heights =
        Arrays.stream(envelopes)
            // sort by width ascending so its trivially increasing
            // then sort by height descending so when there are ties on width, only one is taken in
            // the lis algorithm
            .sorted(
                Comparator.comparingInt((int[] envelope) -> envelope[0])
                    .thenComparing(
                        Comparator.comparingInt((int[] envelope) -> envelope[1]).reversed()))
            .mapToInt(env -> env[1])
            .toArray();

    return lis(heights);
  }

  // TODO O(n * log(n)) lis algorithm
  private int lis(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }

    // dp[i], represents lis ending with nums[i]
    int[] dp = new int[n];
    // base case, singleton subsequences
    Arrays.fill(dp, 1);

    // recursive case
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          // can extend lis ending with nums[j] with nums[i]
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }
}
