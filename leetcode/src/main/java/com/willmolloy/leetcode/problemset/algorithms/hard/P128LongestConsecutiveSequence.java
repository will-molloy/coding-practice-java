package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/longest-consecutive-sequence>https://leetcode.com/problems/longest-consecutive-sequence</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: hash table, pretty obvious since it asks for O(n) solution and expects elements to
 * be compared
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P128LongestConsecutiveSequence {

  // very easy to figure out this approach from the O(n^3) brute force approach

  public int longestConsecutive(int[] nums) {
    // hash table for O(1) contains check
    HashSet<Integer> set =
        Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

    int maxLength = 0;
    for (int num : nums) {
      // find start of sequence
      if (set.contains(num - 1)) {
        continue;
      }
      // found start, measure its length
      int length = 1;
      while (set.contains(num + 1)) {
        num += 1;
        length += 1;
      }
      maxLength = Math.max(maxLength, length);
    }
    return maxLength;
  }
}
