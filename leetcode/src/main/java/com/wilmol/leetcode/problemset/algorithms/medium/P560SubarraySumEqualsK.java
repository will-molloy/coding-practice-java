package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wilmol on 2020-04-16.
 *
 * <p><a
 * href=https://leetcode.com/problems/subarray-sum-equals-k>https://leetcode.com/problems/subarray-sum-equals-k</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Prefix sums, in particular [l, r] = [0, r] - [0, l).
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P303RangeSumQueryImmutable.PrefixSum
 */
class P560SubarraySumEqualsK {

  public int subarraySum(int[] nums, int k) {

    // use of map similar to two-sum problem
    // will store prefix sums and the count of those sums so far
    Map<Integer, Integer> map = new HashMap<>();
    // initial sum is 0 with a count of 1
    map.put(0, 1);

    // track prefix sum so we can get any range sum in O(1):
    // sum[l, r] = sum[0, r] - sum[0, l)
    int prefixSum = 0;

    int count = 0;
    for (int num : nums) {
      prefixSum += num;
      // look at map to find any sum[0, l) = prefixSum - k
      // if it exists, have new solutions
      // i.e.
      // sum[0, l) = prefixSum - k
      // sum[0, l) = sum[0, r] - k
      // k = sum[0, r] - sum[0, l)
      // k = sum[l, r]
      if (map.containsKey(prefixSum - k)) {
        count += map.get(prefixSum - k);
      }
      // update count of sum[0, l] (will become sum[0, l) on next iteration)
      map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
    }
    return count;
  }
}
