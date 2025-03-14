package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/implement-rand10-using-rand7>https://leetcode.com/problems/implement-rand10-using-rand7/</a>
 *
 * <p>Runtime: O(1) (worst case O(inf))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Rejection sampling. Reject samples outside the desired range. Samples in the desired
 * range will still be distributed uniformly.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P470ImplementRand10UsingRand7 {

  private static class SolBase {

    final int rand7() {
      return ThreadLocalRandom.current().nextInt(7) + 1;
    }
  }

  /** The rand7() API is already defined in the parent class SolBase. public int rand7(); */
  static class Solution extends SolBase {

    public int rand10() {
      int row = rand7();
      int col = rand7();
      // index on 2d grid
      int i = (row - 1) * 7 + col;
      if (i <= 40) {
        // i is in [1, 40], size of range = 40 (divisible by 10)
        return (i - 1) % 10 + 1;
      }
      // i is in [41, 49]
      // try again
      return rand10();
    }
  }
}
