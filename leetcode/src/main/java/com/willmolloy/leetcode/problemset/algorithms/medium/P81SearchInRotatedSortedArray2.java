package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/search-in-rotated-sorted-array-ii>https://leetcode.com/problems/search-in-rotated-sorted-array-ii</a>
 *
 * <p>Runtime: O(n) worst case, O(log n) average case
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Test from P33 for rotated case no longer works (comparing with head) since head may also
 * be last. Instead need to handle worst case {@code nums[l] == nums[m]} and move linearly.
 *
 * @see P33SearchInRotatedSortedArray
 * @see P153FindMinimumInRotatedSortedArray
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P154FindMinimumInRotatedSortedArray2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P81SearchInRotatedSortedArray2 {

  // NOTE that the 'getLeftRotation` method doesn't work here (now that there are dupes!)

  public boolean search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int m = l + (r - l) / 2;

      if (nums[m] == target) {
        // target found
        return true;
      }

      if (nums[l] < nums[m]) {
        // [l, m] is sorted TODO ???
        if (nums[l] <= target && target < nums[m]) {
          // target on left side [l, m)
          r = m - 1;
        } else {
          // target on right side (m, r]
          l = m + 1;
        }
      } else if (nums[l] > nums[m]) {
        // [m, r] is sorted TODO ???
        if (nums[m] < target && target <= nums[r]) {
          // target on right side (m, r]
          l = m + 1;
        } else {
          // target on left side [l, m)
          r = m - 1;
        }
      } else {
        // nums[l] = nums[m], move pointer to skip over dupe
        l++;
      }
    }
    return false;
  }
}
