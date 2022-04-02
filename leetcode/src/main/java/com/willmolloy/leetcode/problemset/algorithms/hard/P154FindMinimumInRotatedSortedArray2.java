package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii>https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/</a>
 *
 * <p>Runtime: O(n) worst case, O(log n) average case
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Tweak to P153, worst case where {@code nums[m] == nums[r]} so scan linearly.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P33SearchInRotatedSortedArray
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P81SearchInRotatedSortedArray2
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P153FindMinimumInRotatedSortedArray
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P154FindMinimumInRotatedSortedArray2 {

  public int findMin(int[] nums) {
    int n = nums.length;
    int l = 0;
    int r = n - 1;

    // search [l, r]
    while (l < r) {
      int m = l + (r - l) / 2;

      if (nums[m] > nums[r]) {
        // rotated case, smaller values on right (m, r]
        l = m + 1;
      } else if (nums[m] < nums[r]) {
        // normal case, smaller values on left [l, m]
        r = m;
      } else {
        // nums[m] == nums[r], skip over dupe
        r--;
      }
    }
    // l == r at this point (narrowed in on min)
    return nums[l];
  }
}
