package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/contiguous-array>https://leetcode.com/problems/contiguous-array</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: hashmap and realising that returning to the same 'diff' results in an equal count of 0s
 * and 1s. Intuition: it's obvious when diff=0 the counts are balanced, but after the first element
 * it will be either 1 or -1, so returning to 1 or -1 means we have essentially returned to 0
 * (excluding that first element).
 *
 * @see P523ContinuousSubarraySum
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P525ContiguousArray {

  public int findMaxLength(int[] nums) {
    int max = 0;

    // diff = 0 -> equal number of 1s and 0s
    // diff > 0 -> diff more 1s than 0s
    // diff < 0 -> -diff more 0s than 1s
    int diff = 0;

    // map(key) = first i where key=diff (dont want to replace mappings as we do want this first i
    // to maximise the length)
    // therefore if we find diff=key (again), can say the range (map(diff), i] has equal number of
    // 0s and 1s (since between these indices, we have returned to the same diff of 0s and 1s)
    Map<Integer, Integer> map = new HashMap<>();
    // initially 0 diff at index -1 (haven't processed any element yet)
    // (could not put diff=0 in the map, as it is guaranteed to be a new maximum)
    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        diff--;
      } else {
        diff++;
      }

      Integer firstI = map.get(diff);
      if (firstI == null) {
        map.put(diff, i);
      } else {
        max = Math.max(max, i - firstI);
      }
    }

    return max;
  }
}
