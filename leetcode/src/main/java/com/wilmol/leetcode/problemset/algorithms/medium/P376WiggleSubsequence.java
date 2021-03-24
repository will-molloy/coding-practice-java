package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/wiggle-subsequence>https://leetcode.com/problems/wiggle-subsequence/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Greedy - count when direction changes.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P376WiggleSubsequence {

  // don't need to track max peak or min valley because the prev element is updated implicitly
  // e.g. if continue going up (dir = UP and nums[i] > nums[i - 1]) then we compare with nums[i] as
  // nums[i - 1] in next iteration anyway

  public int wiggleMaxLength(int[] nums) {
    int n = nums.length;

    int len = 1;
    Direction dir = Direction.FLAT;

    for (int i = 1; i < n; i++) {
      if (dir == Direction.UP && nums[i] < nums[i - 1]) {
        // now going down
        dir = Direction.DOWN;
        len++;
      } else if (dir == Direction.DOWN && nums[i] > nums[i - 1]) {
        // now going up
        dir = Direction.UP;
        len++;
      } else if (dir == Direction.FLAT) {
        // starting out
        if (nums[i] > nums[i - 1]) {
          dir = Direction.UP;
          len++;
        } else if (nums[i] < nums[i - 1]) {
          dir = Direction.DOWN;
          len++;
        }
      }
    }
    return len;
  }

  private enum Direction {
    FLAT,
    UP,
    DOWN
  }
}
