package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero>https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Look for {@code prefixSum[0, i] + suffixSum[j, n) = x} with minimum {@code
 * prefixSize + suffixSize}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1658MinimumOperationsToReduceXToZero {

  // example
  // x      = 10
  // nums   = [3, 2, 20, 1, 1, 3] (n = 6)
  // prefix = [3, 5, 25, 26, 27, 30]
  // suffix = [30, 27, 25, 5, 4, 3, 0]
  // prefix[1] + suffix[3] = x
  // prefixSize [0, 1] = 1 - 0 + 1 = 2
  // suffixSize [3, 6) = 6 - 3 = 3
  // totalSize = 2 + 3 = 5

  public int minOperations(int[] nums, int x) {
    int n = nums.length;

    int min = Integer.MAX_VALUE;

    // maps suffix sum -> index
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, n);

    int suffixSum = 0;
    for (int i = n - 1; i >= 0; i--) {
      suffixSum += nums[i];
      if (suffixSum == x) {
        // [i, n)
        int suffixSize = n - i;
        min = Math.min(min, suffixSize);
      }
      if (suffixSum > x) {
        break;
      }
      map.put(suffixSum, i);
    }

    int prefixSum = 0;
    for (int i = 0; i < n; i++) {
      prefixSum += nums[i];
      // want prefixSum[0, i] + suffixSum[j, n) = x
      // lookup suffixSum[j, n) = x - prefixSum[0, i]
      Integer j = map.get(x - prefixSum);
      if (j != null && j > i) {
        // [0, i]
        int prefixSize = i + 1;
        // [j, n)
        int suffixSize = n - j;
        min = Math.min(min, prefixSize + suffixSize);
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
