package com.willmolloy.leetcode.problemset.algorithms.hard;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/count-all-possible-routes>https://leetcode.com/problems/count-all-possible-routes/</a>
 *
 * <p>Runtime: O({@code locations.length}<sup>2</sup> * {@code fuel}) - each location can visit
 * every other location and goes {@code fuel} deep
 *
 * <p>Extra memory: O({@code locations.length} * {@code fuel})
 *
 * <p>Key idea: DFS from {@code start} with {@code fuel} fuel. When reaching {@code finish}, don't
 * stop, just increment the count, only stop when running out of fuel.
 *
 * <p>Representing the problem like this (a tree with {@code i}/{@code fuel} as the node/state) the
 * recursive calls overlap, so dynamic programming (memoisation) can be applied.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
final class P1575CountAllPossibleRoutes {

  private static final int MOD = (int) 1e9 + 7;

  public int countRoutes(int[] locations, int start, int finish, int fuel) {
    dp = new int[locations.length][fuel + 1];
    for (int i = 0; i < locations.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    return dfs(locations, finish, start, fuel);
  }

  private int[][] dp;

  private int dfs(int[] locations, int finish, int i, int fuel) {
    if (dp[i][fuel] != -1) {
      return dp[i][fuel];
    }

    int count = 0;
    if (i == finish) {
      count = 1;
    }

    for (int j = 0; j < locations.length; j++) {
      if (i == j) {
        continue;
      }
      int newFuel = fuel - Math.abs(locations[i] - locations[j]);
      if (newFuel < 0) {
        continue;
      }
      count += dfs(locations, finish, j, newFuel);
      count %= MOD;
    }

    dp[i][fuel] = count;
    return count;
  }
}
