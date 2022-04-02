package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/distribute-candies>https://leetcode.com/problems/distribute-candies/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Alice limits herself to one of each candy and at most n/2 candies. So the answer is:
 *
 * <ul>
 *   <li>n/2 - if NUM_UNIQUE is greater than n/2
 *   <li>NUM_UNIQUE - if NUM_UNIQUE is less than n/2
 * </ul>
 *
 * <p>where NUM_UNIQUE is the number of unique candies.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P575DistributeCandies {

  public int distributeCandies(int[] candyType) {
    int numUnique = (int) Arrays.stream(candyType).distinct().count();
    return Math.min(numUnique, candyType.length / 2);
  }
}
