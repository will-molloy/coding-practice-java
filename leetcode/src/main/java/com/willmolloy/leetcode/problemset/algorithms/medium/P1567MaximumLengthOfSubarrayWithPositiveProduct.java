package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product>https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: First store positions of all zeros. Then consider every subarray between zeros (no
 * longer worry about zeros). When considering a subarray, if the count of negatives is even can use
 * all of it, otherwise compare removing the first and last negative.
 *
 * <p>Further, considering product as 1, -1, or 0 since we only care about the length and actual
 * product may overflow.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1567MaximumLengthOfSubarrayWithPositiveProduct {

  public int getMaxLen(int[] nums) {

    List<Integer> zeros = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeros.add(i);
      }
    }

    if (!zeros.isEmpty()) {
      int len = 0;

      // before zeros
      // [0, firstZero)
      len = Math.max(len, maxLen(nums, 0, zeros.get(0) - 1));

      // after zeros
      // (lastZero, n)
      len = Math.max(len, maxLen(nums, zeros.get(zeros.size() - 1) + 1, nums.length - 1));

      // between zeros
      for (int i = 0; i < zeros.size() - 1; i++) {
        // (zeroI, zeroI+1)
        len = Math.max(len, maxLen(nums, zeros.get(i) + 1, zeros.get(i + 1) - 1));
      }

      return len;
    } else {
      // no zeros
      return maxLen(nums, 0, nums.length - 1);
    }
  }

  // [start, end]
  private int maxLen(int[] nums, int start, int end) {
    int prod = 1;
    for (int i = start; i <= end; i++) {
      if (nums[i] > 0) {
        prod *= 1;
      } else if (nums[i] < 0) {
        prod *= -1;
      } else {
        throw new AssertionError("nums[i] is 0");
      }
    }

    if (prod > 0) {
      // even number of negatives
      return end - start + 1;
    }

    // odd number of negatives
    // compare removing first and last negative
    // i.e. for first negative take the suffix (firstNeg, end]
    // and for last negative take the prefix [start, lastNeg)

    // no point removing in between negatives; may get invalid subarrays (negative products) and the
    // ranges will be smaller anyway

    int len = 0;
    for (int i = start; i <= end; i++) {
      if (nums[i] < 0) {
        // (firstNeg, end]
        len = end - i;
        break;
      }
    }

    for (int i = end; i >= start; i--) {
      if (nums[i] < 0) {
        // [start, lastNeg)
        len = Math.max(len, i - start);
        break;
      }
    }
    return len;
  }
}
