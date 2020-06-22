package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by Will on 2019-07-28 at 00:10.
 *
 * <p><a
 * href=https://leetcode.com/problems/remove-element>https://leetcode.com/problems/remove-element</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Track length of 'new' array (but write in-place); only write elements not equal to {@code
 * val}.
 *
 * @see P26RemoveDuplicatesFromSortedArray
 */
class P27RemoveElement {

  public int removeElement(int[] nums, int val) {
    int length = 0;
    for (int i : nums) {
      if (i != val) {
        // only write elements not equal to val
        nums[length++] = i;
      }
    }
    return length;
  }
}
