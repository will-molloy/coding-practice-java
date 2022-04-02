package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60>https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Lookup remainders in hash table.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P1TwoSum
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1010PairsOfSongsWithTotalDurationsDivisibleBy60 {

  public int numPairsDivisibleBy60(int[] time) {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int t : time) {
      count += map.getOrDefault((60 - t % 60) % 60, 0);
      map.merge(t % 60, 1, Integer::sum);
    }
    return count;
  }
}
