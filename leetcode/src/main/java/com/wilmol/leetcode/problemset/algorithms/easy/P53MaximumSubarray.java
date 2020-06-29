package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-subarray>https://leetcode.com/problems/maximum-subarray</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: leaving out negative prefixes/suffixes from the sum (which may include positive values).
 *
 * @see <a href=https://www.youtube.com/watch?v=umt7t1_X8Rc>Errichto's video</a>
 * @see <a href=https://en.wikipedia.org/wiki/Maximum_subarray_proble>Kadane's algorithm</a>
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P53MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int current = 0;
    for (int num : nums) {
      current += num;
      max = Math.max(max, current);
      current = Math.max(0, current);
    }
    return max;
  }
}
