package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/arranging-coins>https://leetcode.com/problems/arranging-coins/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Subtract 1, 2, 3, etc. until no more coins.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P441ArrangingCoins {

  public int arrangeCoins(int n) {
    int count = 0;
    int i = 1;
    while (n > 0) {
      n -= i++;
      if (n >= 0) {
        count++;
      }
    }
    return count;
  }
}
