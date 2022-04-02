package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target>https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Handling non-overlapping requirement; clearing set is sufficient.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P303RangeSumQueryImmutable.PrefixSum
 * @see P560SubarraySumEqualsK
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1546MaximumNumberOfNonOverlappingSubarrayWithSumEqualsTarget {

  public int maxNonOverlapping(int[] nums, int target) {
    int n = nums.length;

    // P560SubarraySumEqualsK tweak (non overlapping)

    Set<Integer> set = new HashSet<>();
    int prefixSum = 0;
    set.add(prefixSum);

    int count = 0;

    for (int i = 0; i < n; i++) {
      prefixSum += nums[i];

      // want some sum(nums[l, r]) = target
      // can get sum(nums[l, r]) in O(1) time:
      // sum(nums[l, r]) = sum(nums[0, r]) - sum(nums[0, l))

      // target          = sum(nums[l, r])
      // prefix sum      = sum(nums[0, i])
      // i               = r

      // sum(nums[l, r]) = sum(nums[0, r]) - sum(nums[0, l))
      // target          = prefixSum - sum(nums[0, l))
      // sum(nums[0, l)) = prefixSum - target

      // so find any sum(nums[0, l)) = prefixSum - target

      if (set.contains(prefixSum - target)) {
        count++;
        // clear so don't get overlapping ranges, we use this i = r so can't reuse the l
        set.clear();
      }

      // store prefixSum as range sum for [0, i] = [0, l] (next iteration will be [0, l))
      set.add(prefixSum);
    }

    return count;
  }
}
