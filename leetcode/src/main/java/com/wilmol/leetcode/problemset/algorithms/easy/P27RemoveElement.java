package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by Will on 2019-07-28 at 00:10.
 *
 * <p><a
 * href=https://leetcode.com/problems/remove-element>https://leetcode.com/problems/remove-element</a>
 *
 * <p>Runtime: O(n), O(1) extra memory
 */
class P27RemoveElement {

  public int removeElement(int[] nums, int val) {
    int length = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[length++] = nums[i];
      }
    }
    return length;
  }
}
