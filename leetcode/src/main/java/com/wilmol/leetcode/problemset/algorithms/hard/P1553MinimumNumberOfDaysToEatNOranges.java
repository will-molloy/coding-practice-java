package com.wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges>https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/</a>
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P1553MinimumNumberOfDaysToEatNOranges {

  int minDays(int n);

  /**
   * Dynamic programming solution.
   *
   * <p>Runtime: O(log(n)) (divide by 2 or 3 each step)
   *
   * <p>Extra memory: O(log(n))
   *
   * <p>Key: {@code dp[n]} needs to store same value each time (what it means for dp to work...).
   * Forcing n/2 and n/3 (by adding n%2 and n%3) simplifies the cases.
   */
  class Dp implements P1553MinimumNumberOfDaysToEatNOranges {

    // use map rather than array since n can be big (2billion) and recursion is sparse
    private final Map<Integer, Integer> dp = new HashMap<>();

    @Override
    public int minDays(int n) {
      if (n == 0) {
        return 0;
      }

      if (!dp.containsKey(n)) {
        // one by one = n
        // half = one by one of n % 2 to reach n/2 + 1 (day eating n/2) + result for n/2
        // two third = one by one of n % 3 to reach n/3 + 1 (day eating 2/3*n) + result for n/3
        dp.put(n, min(n, n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
      }
      return dp.get(n);
    }

    private static int min(int... ints) {
      return Arrays.stream(ints).min().getAsInt();
    }
  }

  /**
   * BFS solution.
   *
   * <p>Runtime: O(log(n)) (divide by 2 or 3 each step)
   *
   * <p>Extra memory: O(log(n))
   *
   * <p>Key: Traverse tree starting from n, answer is min number of levels to reach 0 (which BFS
   * solves).
   *
   * @see P1345JumpGame4
   */
  class Bfs implements P1553MinimumNumberOfDaysToEatNOranges {

    @Override
    public int minDays(int n) {
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(n);

      int level = 0;

      Set<Integer> seen = new HashSet<>();

      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int node = queue.remove();
          if (node == 0) {
            return level;
          }
          if (!seen.add(node)) {
            continue;
          }
          queue.add(node - 1);
          if (node % 2 == 0) {
            queue.add(node / 2);
          }
          if (node % 3 == 0) {
            queue.add(node / 3);
          }
        }
        level++;
      }
      throw new IllegalArgumentException("Failed to reach 0 oranges");
    }
  }
}
