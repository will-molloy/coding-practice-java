package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by Will on 2019-07-27 at 22:16.
 *
 * <p><a
 * href=https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii>https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii</a>
 *
 * <p>Runtime: O(n), O(1) extra memory
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P26RemoveDuplicatesFromSortedArray
 */
class P80RemoveDuplicatesFromSortedArray2 {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }

    int length = 2;
    // keep track of two most recent values
    int prevPrev = nums[0];
    int prev = nums[1];

    for (int i = 2; i < nums.length; i++) {
      int next = nums[i];

      if (next > prev) {
        // greater than prev, must be allowed as its a new value
        nums[length] = next;
        length += 1;

        // swap
        int temp = prev;
        prev = next;
        prevPrev = temp;

      } else if (next > prevPrev && prevPrev != prev) {
        // greater than prevPrev, only allowed if two most recent differ
        nums[length] = next;
        length += 1;

        // two most recent values are now equal, since if it were a new larger value it
        // would've passed the first condition
        prev = next;
        prevPrev = next;
      }
    }
    return length;
  }
}
