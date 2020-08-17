package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/distribute-candies-to-people>https://leetcode.com/problems/distribute-candies-to-people/</a>
 *
 * <p>Runtime: O(sqrt(candies)) (consume candies at rate of O(n<sup>2</sup>), so runtime is the
 * inverse)
 *
 * <p>Extra memory: O(1) (O(n) including return value)
 *
 * <p>Key: Simulate candy distribution, modulo helps clean up code.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1103DistributeCandiesToPeople {

  public int[] distributeCandies(int candies, int n) {
    int[] arr = new int[n];
    int i = 0;
    int candy = 1;
    while (candies > 0) {
      arr[i % n] += Math.min(candy, candies);
      candies -= candy;
      candy++;
      i++;
    }
    return arr;
  }
}
