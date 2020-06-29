package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/climbing-stairs>https://leetcode.com/problems/climbing-stairs</a>
 *
 * <p>Key: dynamic programming, fibonacci sequence
 *
 * @see com.wilmol.dsa.dp.Fibonacci
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P70ClimbingStairs {

  int climbStairs(int n);

  /**
   * Recursive (top down) solution.
   *
   * <p>Runtime: O(2<sup>n</sup>)
   *
   * <p>Space: O(n)
   */
  class RecursiveTopDown implements P70ClimbingStairs {

    @Override
    public int climbStairs(int n) {
      // assumed positive n else stackoverflow
      if (n == 0 || n == 1) {
        return 1;
      }
      if (n == 2) {
        return 2;
      }
      // either take 1 step or 2 steps, result (number of ways) is sum of both
      return climbStairs(n - 1) + climbStairs(n - 2);
    }
  }

  /**
   * Iterative (bottom up) solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n)
   */
  class IterativeBottomUp implements P70ClimbingStairs {

    @Override
    public int climbStairs(int n) {
      if (n <= 1) {
        return 1;
      }
      // can come from either i-1 or i-2 step
      // so dp[i] = dp[i - 1] + dp[i - 2]
      int[] dp = new int[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }
  }

  /**
   * Iterative (bottom up) solution with constant space use.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   */
  class IterativeBottomUpConstantSpace implements P70ClimbingStairs {

    @Override
    public int climbStairs(int n) {
      int a = 1;
      int b = 1;
      for (int i = 2; i <= n; i++) {
        int temp = b;
        b = a + b;
        a = temp;
      }
      return b;
    }
  }
}
