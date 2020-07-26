package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/find-minimum-in-rotated-sorted-array>https://leetcode.com/problems/find-minimum-in-rotated-sorted-array</a>
 *
 * <p>Runtime: O(log n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Test for rotated/normal case.
 *
 * @see P33SearchInRotatedSortedArray
 * @see P81SearchInRotatedSortedArray2
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P154FindMinimumInRotatedSortedArray2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P153FindMinimumInRotatedSortedArray {

  public int findMin(int[] nums) {
    int n = nums.length;
    int l = 0;
    int r = n - 1;

    // search [l, r]
    // don't want l <= r because then we would loop forever on l == r == m
    while (l < r) {
      int m = l + (r - l) / 2;

      if (nums[m] > nums[r]) {
        // rotated case, smaller values are on the right (m, r]
        l = m + 1;
      } else { // nums[m] <= nums[r]
        // normal case, smaller values are on the left [l, m]
        // (don't know if nums[m] isn't min so need to keep m in search range)
        r = m;
      }
    }
    // l == r at this point (narrowed in on min)
    return nums[l];
  }
}
