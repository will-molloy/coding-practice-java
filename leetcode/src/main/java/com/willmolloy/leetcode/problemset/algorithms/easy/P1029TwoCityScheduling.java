package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a
 * href=https://leetcode.com/problems/two-city-scheduling>https://leetcode.com/problems/two-city-scheduling/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Sort first so greedy approach can be used.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1029TwoCityScheduling {

  public int twoCitySchedCost(int[][] costs) {
    int n = costs.length / 2;
    int a = 0;
    int b = 0;
    int answer = 0;

    // because we have to consider every pair (by including one pair element in the result)
    // sort such that the difference between city a and city b cost is largest first
    // then we can make the greedy choice of picking the cheapest city before running into the issue
    // of already having allocated n people to a city (in which case we may have to start picking
    // the more expensive of the two cities)
    // basically we want our savings to be maximised
    Arrays.sort(
        costs, Comparator.comparingInt((int[] cost) -> Math.abs(cost[0] - cost[1])).reversed());

    for (int[] cost : costs) {
      if (a == n) {
        // already allocated n people to city a, have to choose city b
        answer += cost[1];
      } else if (b == n) {
        // already allocated n people to city b, have to choose city a
        answer += cost[0];
      } else if (cost[0] < cost[1]) {
        // city a is cheaper
        answer += cost[0];
        a++;
      } else {
        // city b is cheaper
        answer += cost[1];
        b++;
      }
    }
    return answer;
  }
}
