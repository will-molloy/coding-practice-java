package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a
 * href=https://leetcode.com/problems/best-team-with-no-conflicts>https://leetcode.com/problems/best-team-with-no-conflicts/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Sort first then it becomes a variant of LIS problem.
 *
 * @see P300LongestIncreasingSubsequence
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1626BestTeamWithNoConflicts {

  public int bestTeamScore(int[] scores, int[] ages) {
    int n = scores.length;

    int[][] players = new int[n][2];
    for (int i = 0; i < n; i++) {
      players[i][0] = ages[i];
      players[i][1] = scores[i];
    }
    // sort by age ascending and break ties with score ascending
    Arrays.sort(
        players, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1]));

    // now the problem becomes similar to LIS problem

    // dp[i]: max sum of subsequence ending at i
    int[] dp = new int[n];
    // global max (we will consider max sum of subsequence ending at each i)
    int max = 0;

    for (int i = 0; i < n; i++) {
      // at minimum, a player can form a team with just themselves
      dp[i] = players[i][1];
      for (int j = 0; j < i; j++) {
        // check it wont create a conflict (i.e. older player has larger score)
        // if same age this will be true since we sorted same age by score ascending
        if (players[i][1] >= players[j][1]) {
          // no conflict, player i can extend player j's team
          // compare current max for subsequence ending at i with extending subsequence ending at j
          dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
