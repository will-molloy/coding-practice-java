package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/min-cost-climbing-stairs>https://leetcode.com/problems/min-cost-climbing-stairs</a>
 *
 * <p>Key: dynamic programming
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P746MinCostClimbingStairs {

  int minCostClimbingStairs(int[] costs);

  /**
   * Recursive (forward). TLE on leetcode.
   *
   * <p>Runtime: O(2<sup>n</sup>)
   *
   * <p>Space: O(n)
   */
  class Recursive implements P746MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] costs) {
      // start at -1: initially have to decide to start (and take some cost) at 0 or 1
      return cost(costs, -1, 0);
    }

    private int cost(int[] costs, int i, int cost) {
      if (i == costs.length - 2 || i == costs.length - 1) {
        return cost; // can leave staircase
      }
      int step1 = cost(costs, i + 1, cost + costs[i + 1]);
      int step2 = cost(costs, i + 2, cost + costs[i + 2]);
      return Math.min(step1, step2);
    }
  }

  /**
   * Dp (forward).
   *
   * <p><b>NOTE</b> this problem can be solved in either direction (i.e. considering
   * forward/backward iterative approach).
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n) TODO can be O(1) space see leetcode solution page
   */
  class Dp implements P746MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] costs) {
      int[] dp = new int[costs.length];

      dp[0] = costs[0];
      dp[1] = costs[1];

      for (int i = 2; i < dp.length; i++) {
        int step1 = dp[i - 1];
        int step2 = dp[i - 2];
        dp[i] = costs[i] + Math.min(step1, step2);
      }

      int leaveLastStep = dp[dp.length - 1];
      int leave2ndLastStep = dp[dp.length - 2];
      return Math.min(leaveLastStep, leave2ndLastStep);
    }
  }
}
