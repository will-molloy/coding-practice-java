package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/shortest-unsorted-continuous-subarray>https://leetcode.com/problems/shortest-unsorted-continuous-subarray</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Was able to use two-pointer approach to find where array stops increasing (from the left)
 * and where array stops decreasing (from the right). Was missing finding insertion location for
 * min/max element which covers the case when elements are equal.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P581ShortestUnsortedContinuousSubarray {

  public int findUnsortedSubarray(int[] nums) {
    final int n = nums.length;

    boolean startFound = false;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      // find start of unsorted subsequence
      if (nums[i] > nums[i + 1]) {
        startFound = true;
      }
      // find min element beyond start of unsorted subsequence
      if (startFound) {
        min = Math.min(min, nums[i + 1]);
      }
    }
    // find where min should be located in the sorted sequence
    int l = 0;
    for (; l < n; l++) {
      if (min < nums[l]) {
        break;
      }
    }

    boolean endFound = false;
    int max = Integer.MIN_VALUE;
    for (int i = n - 1; i > 0; i--) {
      // find end of unsorted subsequence
      if (nums[i] < nums[i - 1]) {
        endFound = true;
      }
      // find max element before end of unsorted subsequence
      if (endFound) {
        max = Math.max(max, nums[i - 1]);
      }
    }
    // find where max should be located in the sorted sequence
    int r = n - 1;
    for (; r >= 0; r--) {
      if (max > nums[r]) {
        break;
      }
    }

    // [l, r]
    return r - l < 0 ? 0 : r - l + 1;
  }
}
