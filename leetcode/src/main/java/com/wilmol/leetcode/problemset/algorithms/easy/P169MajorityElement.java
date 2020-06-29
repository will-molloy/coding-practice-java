package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/majority-element>https://leetcode.com/problems/majority-element</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n) TODO exists O(1) space solution (Boyer-Moore Voting Algorithm)
 *
 * <p>Key: hash table
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P169MajorityElement {

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      int frequency = map.getOrDefault(num, 0) + 1;
      if (frequency > nums.length / 2) {
        return num;
      }
      map.put(num, frequency);
    }
    throw new IllegalArgumentException("No majority element");
  }
}
