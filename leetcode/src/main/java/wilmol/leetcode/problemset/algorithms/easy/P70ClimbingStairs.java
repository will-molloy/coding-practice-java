package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2019-12-15.
 *
 * <p><a
 * href=https://leetcode.com/problems/climbing-stairs>https://leetcode.com/problems/climbing-stairs</a>
 *
 * <p>Key: dynamic programming, fibonacci sequence
 *
 * @see wilmol.dsa.dp.Fibonacci
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
   * <p>Space: O(1)
   */
  class IterativeBottomUp implements P70ClimbingStairs {

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
