package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/k-diff-pairs-in-an-array>https://leetcode.com/problems/k-diff-pairs-in-an-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: In second pass, iterate key/entry set rather than {@code nums} such that duplicate
 * pairs are avoided.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P1TwoSum
 * @see P1497CheckIfArrayPairsAreDivisibleByK
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P532KDiffPairsInAnArray {

  public int findPairs(int[] nums, int k) {
    // compute frequencies
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }

    // count pairs
    int count = 0;
    // iterate keySet/entrySet such that duplicate pairs are avoided
    for (var e : map.entrySet()) {
      if (k == 0) {
        // a == b, test there exists another to complete a pair
        if (e.getValue() > 1) {
          count++;
        }
      } else {
        // lookup a (key - k) or b (key + k), doesn't matter
        if (map.containsKey(e.getKey() - k)) {
          count++;
        }
      }
    }
    return count;
  }
}
