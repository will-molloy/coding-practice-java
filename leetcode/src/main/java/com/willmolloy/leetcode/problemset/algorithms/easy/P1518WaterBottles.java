package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/water-bottles>https://leetcode.com/problems/water-bottles/</a>
 *
 * <p>Runtime: O(lg(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Simulate the process.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1518WaterBottles {

  public int numWaterBottles(int numBottles, int numExchange) {
    int numFull = numBottles;
    int numEmpty = 0;

    int numDrink = 0;
    while (numFull > 0) {
      numDrink += numFull;
      numEmpty += numFull;
      numFull = numEmpty / numExchange;
      numEmpty = numEmpty % numExchange;
    }
    return numDrink;
  }
}
