package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers>https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/</a>
 *
 * <p>Runtime: O(n1<sup>2</sup> + n2<sup>2</sup>)
 *
 * <p>Extra memory: O(n1 + n2)
 *
 * <p>Key: Precompute square counts.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1577NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {

  // TODO can do O(n1 + n2) time

  public int numTriplets(int[] nums1, int[] nums2) {
    int count1 = count(nums1, nums2);
    int count2 = count(nums2, nums1);
    return count1 + count2;
  }

  private int count(int[] nums1, int[] nums2) {
    Map<Long, Integer> squareCounts = new HashMap<>();
    for (int num : nums1) {
      long square = (long) num * num;
      squareCounts.merge(square, 1, Integer::sum);
    }

    int count = 0;
    for (int j = 0; j < nums2.length; j++) {
      for (int k = j + 1; k < nums2.length; k++) {
        long prod = (long) nums2[j] * nums2[k];
        count += squareCounts.getOrDefault(prod, 0);
      }
    }
    return count;
  }
}
