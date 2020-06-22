package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wilmol on 2020-04-16.
 *
 * <p><a
 * href=https://leetcode.com/problems/continuous-subarray-sum>https://leetcode.com/problems/continuous-subarray-sum</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Very similar to {@link P525ContiguousArray}; think of a cipher wheel with 'k' units,
 * returning to the same position means you moved 'n*k' units.
 *
 * @see P525ContiguousArray
 */
class P523ContinuousSubarraySum {

  public boolean checkSubarraySum(int[] nums, int k) {
    // map stores: sum % k -> first index where sum % k occurred
    // (need index to verify range of at least 2 elements)
    // (want this first index so we dont override with ranges of size 1)
    Map<Integer, Integer> map = new HashMap<>();
    int prefixSum = 0;
    // initially sum=0 at index -1 (haven't processed any element yet)
    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      if (k != 0) {
        // compute sum % k
        prefixSum %= k;
      }

      // if map already contains a mapping for sum % k then we have returned to the same position
      // (think of a cipher wheel, or clock)
      // therefore we have moved exactly n * k units
      // i.e. sum(nums(firstI, i]) equals n * k
      if (map.containsKey(prefixSum)) {
        int firstI = map.get(prefixSum);
        if (i - firstI >= 2) {
          return true;
        }
      } else {
        map.put(prefixSum, i);
      }
    }
    return false;
  }
}
