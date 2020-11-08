package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position>https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Zero cost to move chip to position with same parity, so move all even to odd or all odd
 * to even, whichever is cheapest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1217MinimumCostToMoveChipsToTheSamePosition {

  public int minCostToMoveChips(int[] position) {
    int even = 0;
    int odd = 0;
    for (int i : position) {
      if (i % 2 == 0) {
        even++;
      } else {
        odd++;
      }
    }
    return Math.min(even, odd);
  }
}
