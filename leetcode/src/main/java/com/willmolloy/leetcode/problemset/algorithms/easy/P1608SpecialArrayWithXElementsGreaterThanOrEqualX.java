package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x>https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>) TODO O(n log n) is possible
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Brute force. {@code nums.length} is upper bound on {@code x} since if every element
 * were larger, {@code nums.length} would be returned.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1608SpecialArrayWithXElementsGreaterThanOrEqualX {

  public int specialArray(int[] nums) {
    for (int x = 0; x <= nums.length; x++) {
      int count = 0;
      for (int num : nums) {
        if (num >= x) {
          count++;
        }
      }
      if (count == x) {
        return x;
      }
    }
    return -1;
  }
}
