package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/move-zeroes>https://leetcode.com/problems/move-zeroes</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: able to place elements at the front (while keeping them at the back) because the back
 * will be written to later
 *
 * @see <a href=https://www.youtube.com/watch?v=E7xxGi84Tso>Errichto's video</a>
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P283MoveZeroes {

  // TODO more optimal solution (fewer operations but still O(n)) exists where you swap elements

  public void moveZeroes(int[] nums) {
    int i = 0;
    // place non-zeroes at front
    for (int num : nums) {
      if (num != 0) {
        nums[i] = num;
        i += 1;
      }
    }

    // fill in tail of zeroes
    for (; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
