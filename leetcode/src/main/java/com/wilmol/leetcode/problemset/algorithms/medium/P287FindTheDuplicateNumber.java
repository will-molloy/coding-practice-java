package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-06-25.
 *
 * <p><a
 * href=https://leetcode.com/problems/find-the-duplicate-number>https://leetcode.com/problems/find-the-duplicate-number/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Cycle detection.
 */
class P287FindTheDuplicateNumber {

  // must not modify array or use extra memory
  // so not allowed to use sorting, hashing, changing nums to negative nums, etc.

  public int findDuplicate(int[] nums) {
    // idea is to traverse the numbers (since they fit in [1, n] with n + 1 elements)
    // traverse by using num as index of next num (i.e. nums[num])
    // there must be a cycle as there is a duplicate... (at most n unique nums in n + 1 buckets)
    // the node which begins a cycle must be the duplicate (just draw diagram)

    // using slow/fast pointer method for cycle detection

    // find intersection point (enter the cycle)
    int head = nums[0];
    int slow = nums[head];
    int fast = nums[nums[head]];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    // find the start of the cycle (not always the intersection point)
    int node = head;
    int intersection = fast;
    while (node != intersection) {
      node = nums[node];
      intersection = nums[intersection];
    }
    return node;
  }
}
