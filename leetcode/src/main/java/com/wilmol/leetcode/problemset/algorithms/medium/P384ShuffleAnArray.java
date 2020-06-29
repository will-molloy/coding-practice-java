package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/shuffle-an-array>https://leetcode.com/problems/shuffle-an-array/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Swap with random index in not yet processed range.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P384ShuffleAnArray {

  /** Solution. */
  static class Solution {

    private final int[] nums;

    Solution(int[] nums) {
      this.nums = nums;
    }

    public int[] reset() {
      return nums;
    }

    public int[] shuffle() {
      int[] copy = nums.clone();

      int n = nums.length;
      for (int i = 0; i < n; i++) {
        // random index in not yet processed range
        int rand = ThreadLocalRandom.current().nextInt(i, n);
        // swap
        int temp = copy[rand];
        copy[rand] = copy[i];
        copy[i] = temp;
      }
      return copy;
    }
  }
}
