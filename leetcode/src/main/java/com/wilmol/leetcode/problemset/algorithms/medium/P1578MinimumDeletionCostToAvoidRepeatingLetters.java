package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters>https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Keep max in each consecutive run of characters.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1578MinimumDeletionCostToAvoidRepeatingLetters {

  public int minCost(String s, int[] cost) {
    char[] chars = s.toCharArray();

    // runs of consecutive characters [start, end]
    char c = chars[0];
    int start = 0;
    int end = 0;
    List<List<Integer>> runs = new ArrayList<>();
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == c) {
        end++;
      } else {
        runs.add(Arrays.asList(start, end));
        c = chars[i];
        start = i;
        end = i;
      }
    }
    runs.add(Arrays.asList(start, end));

    return cost(runs, cost);
  }

  private int cost(List<List<Integer>> runs, int[] cost) {
    int ans = 0;
    for (List<Integer> run : runs) {
      int start = run.get(0);
      int end = run.get(1);
      // keep max
      int max = 0;
      int sum = 0;
      for (int i = start; i <= end; i++) {
        max = Math.max(cost[i], max);
        sum += cost[i];
      }
      ans += sum - max;
    }
    return ans;
  }
}
