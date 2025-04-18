package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/smallest-range-ii>https://leetcode.com/problems/smallest-range-ii/</a>
 *
 * <p>Runtime: O(n * log(n)) ({@link Arrays#sort})
 *
 * <p>Extra memory: O(log(n)) ({@link Arrays#sort})
 *
 * <p>Key idea: First sort, add {@code k} to smaller {@code nums[i]} and subtract {@code k} from
 * larger {@code nums[i]}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P910SmallestRange2 {

  // CHECKSTYLE IGNORE AbbreviationAsWordInName FOR NEXT 1 LINES
  public int smallestRangeII(int[] nums, int k) {
    int n = nums.length;
    Arrays.sort(nums);
    int ans = nums[n - 1] - nums[0];

    for (int i = 0; i < nums.length - 1; ++i) {
      int high = Math.max(nums[n - 1] - k, nums[i] + k);
      int low = Math.min(nums[0] + k, nums[i + 1] - k);
      ans = Math.min(ans, high - low);
    }
    return ans;
  }
}
