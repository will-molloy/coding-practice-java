package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold>https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/</a>
 *
 * <p>Runtime: O({@code nums.length} * log(max({@code nums})))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Picking divisor from [1, max(nums)] creates a partition [false, true], so can use
 * binary search to find the best divisor.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P278FirstBadVersion
 * @see P1482MinimumNumberOfDaysToMakeMBouquets
 * @see P1552MagneticForceBetweenTwoBalls
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1283FindTheSmallestDivisorGivenAThreshold {

  public int smallestDivisor(int[] nums, int threshold) {
    // picking divisor from [1, max(nums)] creates partition like: [f f f f f f f f t t t t t t t t]
    // want the first true

    int max = Arrays.stream(nums).max().getAsInt();
    int l = 1;
    int r = max;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (isOk(m, nums, threshold)) {
        // search first half for earlier true
        r = m - 1;
      } else {
        // search second half for a true
        l = m + 1;
      }
    }
    return l;
  }

  private boolean isOk(int d, int[] nums, int threshold) {
    int sum = 0;
    for (int num : nums) {
      sum += ceil(num, d);
    }
    return sum <= threshold;
  }

  private int ceil(int n, int d) {
    int q = n / d;
    if (n % d == 0) {
      return q;
    } else {
      return q + 1;
    }
  }
}
