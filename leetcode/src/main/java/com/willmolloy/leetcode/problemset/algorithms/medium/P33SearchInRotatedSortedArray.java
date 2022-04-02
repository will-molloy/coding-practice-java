package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/search-in-rotated-sorted-array>https://leetcode.com/problems/search-in-rotated-sorted-array/</a>
 *
 * <p>Runtime: O(log n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: The rotation partitions the sorted sequence into 2 sorted partitions. E.g. <3,4,5,0,1,2>
 * = <3,4,5> ++ <0,1,2>. (If no rotation then second partition is empty.)
 *
 * @see P81SearchInRotatedSortedArray2
 * @see P153FindMinimumInRotatedSortedArray
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P154FindMinimumInRotatedSortedArray2
 * @see <a href=https://youtu.be/84a8fQp5hJA>Errichto's video</a>
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P33SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) {
      return -1;
    }

    int l = 0;
    int r = n - 1;
    int head = nums[0];

    // searching range [l, r] hence need to include l == r
    while (l <= r) {
      int m = l + (r - l) / 2;
      int value = nums[m];

      if (value == target) {
        // target found
        return m;
      }

      // true if current value is in the left sorted partition
      boolean currentValueLeft = value >= head;
      // true if target is in the left sorted partition
      boolean targetLeft = target >= head;

      if (currentValueLeft == targetLeft) {
        // current value and target are in the same sorted partition
        // can perform standard binary search
        if (value > target) {
          // search left [l, m)
          r = m - 1;
        } else {
          // search right (m, r]
          l = m + 1;
        }
      } else {
        // current value and target are in different sorted partitions
        // need to search the partition that contains target
        if (targetLeft) {
          // search left [l, m)
          r = m - 1;
        } else {
          // search right (m, r]
          l = m + 1;
        }
      }
    }
    return -1;
  }
}
