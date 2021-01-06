package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-erasure-value>https://leetcode.com/problems/maximum-erasure-value/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Problem is: maximum contiguous sub array sum having unique elements.
 *
 * <p>Use two pointers ({@code start} and {@code end}) and maintain a hashset to represent the
 * current subarray. Expand when next element is unique, otherwise shrink until its unique.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P53MaximumSubarray
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1695MaximumErasureValue {

  public int maximumUniqueSubarray(int[] nums) {
    int n = nums.length;

    int start = 0;
    int end = 1;
    Set<Integer> set = new HashSet<>(Set.of(nums[0]));

    int current = nums[0];
    int max = current;

    while (start < n - 1 && end < n) {
      if (!set.contains(nums[end])) {
        // next element is unique, expand sub array
        // (sum must get bigger since there are no negative values)
        current += nums[end];
        set.add(nums[end]);
        end++;
        max = Math.max(max, current);
      } else {
        // shrink sub array until next element is unique
        current -= nums[start];
        set.remove(nums[start]);
        start++;
      }
    }
    return max;
  }
}
