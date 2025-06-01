package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-number-of-coins-you-can-get>https://leetcode.com/problems/maximum-number-of-coins-you-can-get/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(n) (only cause copied array to list)
 *
 * <p>Key idea: Greedy, take every second largest coin.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1561MaximumNumberOfCoinsYouCanGet {

  public int maxCoins(int[] piles) {
    List<Integer> list = Arrays.stream(piles).boxed().sorted(Comparator.reverseOrder()).toList();

    // 9,8,7,6,5,1,2,3,4
    // 9 8 7 6 5 4 3 2 1
    // A ^ A ^ A ^ B B B

    int n = piles.length / 3;
    int coins = 0;
    int count = 0;
    for (int i = 1; count < n; i += 2) {
      coins += list.get(i);
      count++;
    }
    return coins;
  }
}
