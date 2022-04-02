package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-sum-circular-subarray>https://leetcode.com/problems/maximum-sum-circular-subarray/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: After computing prefix sum, compute max prefix sum so don't have to compare every {@code
 * i} with every {@code j} ({@code j - i >= 2}) cause we're able to compare j with the closest
 * possible {@code i} ({@code j - i == 2}) instead.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P918MaximumSumCircularSubarray {

  // TODO simpler approach where you subtract the min subarray sum from the total

  public int maxSubarraySumCircular(int[] a) {
    int n = a.length;

    // case1 normal max subarray problem
    // i.e. no wrapping around
    // i.e. one interval: [0, n)
    int max = Integer.MIN_VALUE;
    int current = 0;
    for (int i : a) {
      current += i;
      max = Math.max(max, current);
      current = Math.max(0, current);
    }

    // case2 max subarray wraps around
    // consider two intervals: [0, i] and [j, n) where j - i >= 2 (if j - i == 1 it's one interval)
    // where the sum is maximised
    // e.g. <5, -3, 5> -> [0, 0] (<5>) + [2, 2] (<5>) = 10

    int[] prefix = new int[n];
    prefix[0] = a[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + a[i];
    }

    // at this point we could try all prefix[i] + suffix[j] with j - i >= 2
    // but that would be O(n^2)

    // trick is to compute this maxPrefix
    // so we get max sum *so far* for [0, i]
    // i.e. maxPrefix[i] may not be a sum ending with a[i] but an earlier a[i]
    int[] maxPrefix = new int[n];
    maxPrefix[0] = prefix[0];
    for (int i = 1; i < n; i++) {
      maxPrefix[i] = Math.max(maxPrefix[i - 1], prefix[i]);
    }

    // can now try maxPrefix[i - 2] + suffix[i]
    // i.e. max sum so far for [0, i - 2] + sum [i, n)
    // essentially comparing all prefix[i] + suffix[j]; we have just pre computed the best prefix[i]
    // for suffix[j]
    int suffix = 0;
    for (int i = n - 1; i >= 2; i--) {
      suffix += a[i];
      max = Math.max(max, maxPrefix[i - 2] + suffix);
    }

    return max;
  }
}
