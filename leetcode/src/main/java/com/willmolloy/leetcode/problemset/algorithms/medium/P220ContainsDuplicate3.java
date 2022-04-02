package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * <a
 * href=https://leetcode.com/problems/contains-duplicate-iii>https://leetcode.com/problems/contains-duplicate-iii/</a>
 *
 * <p>Runtime: O(n * log(k))
 *
 * <p>Extra memory: O(k)
 *
 * <p>Key: Sorted set ({@link NavigableSet}, {@link TreeSet}); use {@link NavigableSet#subSet} to
 * test if there is anything in a range.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P220ContainsDuplicate3 {

  // need Long cause overflow garbage

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (t < 0) {
      return false;
    }

    // sliding window
    NavigableSet<Long> set = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {
      // abs difference
      // |nums[i] - nums[j]| <= t

      // if nums[j] <= nums[i] then:
      // nums[i] - t <= nums[j]

      // if nums[j] >= nums[i] then:
      // nums[j] <= t + nums[i]

      // which is:
      // nums[i] - t <= nums[j] <= t + nums[i]

      // basically, is there anything in the range [num - t, num + t]?

      if (!set.subSet((long) nums[i] - t, true, (long) nums[i] + t, true).isEmpty()) {
        return true;
      }

      set.add((long) nums[i]);
      if (set.size() > k) {
        set.remove((long) nums[i - k]);
      }
    }
    return false;
  }
}

// set.ceiling(nums[i] - t) || set.floor(nums[i] + t)
// doesn't work because of the ||
// i.e. it returns true for:
// >= nums[i] - t OR <= nums[i] + t
// rather than:
// >= nums[i] - t AND <= nums[i] + t
