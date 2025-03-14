package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array>https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array</a>
 *
 * <p>Runtime: O(log n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: sorted sequence, so O(log n) binary search can be used
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P34FindFirstAndLastPositionOfElementInSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int head = firstPosition(nums, target);
    int last = firstPosition(nums, target + 1) - 1;
    if (head <= last) {
      // valid range
      return new int[] {head, last};
    } else {
      // target not found
      return new int[] {-1, -1};
    }
  }

  // modified binary search which finds the first instance of the given target
  private int firstPosition(int[] nums, int target) {
    // default, when target > nums.last, first position is beyond the array
    int firstPos = nums.length;

    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] >= target) {
        firstPos = mid;
        high = mid - 1;
      } else { // nums[mid] < target
        low = mid + 1;
      }
    }
    return firstPos;
  }
}
