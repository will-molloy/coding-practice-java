package com.wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by wilmol on 2020-05-03.
 *
 * <p><a
 * href=https://leetcode.com/problems/sliding-window-maximum>https://leetcode.com/problems/sliding-window-maximum/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(k)
 *
 * <p>Key: It is guaranteed the beginning of the window is removed first (by definition!).
 *
 * <p>Therefore, can safely remove smaller elements from the end of the queue (e.g. have window =
 * [1, 2, 3], no reason to keep the 1 or the 2; they'll be removed before the 3 and the 3 will
 * always be the maximum).
 *
 * <p>But not vice versa because it is unknown what'll be added next (e.g. have [3, 2, 1], need to
 * keep the 1 and the 2 because the 3 (the maximum) will be removed first and future values could be
 * smaller meaning they'll become the maximum(s)).
 *
 * @see P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit
 */
class P239SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;

    int[] result = new int[n - k + 1];

    int l = 0;
    int r = 0;

    // deque will hold indices of nums for range [l, r] in ascending order (a subset)
    // will store them such that the head of the queue is the index of the maximum element
    Deque<Integer> maxs = new ArrayDeque<>();

    // create initial window
    while (r - l + 1 < k) {
      // we're moving r (growing the window)
      // so if last element is smaller than next element remove it as it will never become a maximum
      // in the range [l, r]
      while (!maxs.isEmpty() && nums[maxs.peekLast()] <= nums[r]) {
        maxs.removeLast();
      }
      // grow window
      maxs.add(r++);
    }

    // perform sliding window
    while (r < n) {
      // we're moving r (growing the window)
      // so if last element is smaller than next element remove it as it will never become a maximum
      // in the range [l, r]
      // TODO anyway to remove this duplicated loop?
      while (!maxs.isEmpty() && nums[maxs.peekLast()] <= nums[r]) {
        maxs.removeLast();
      }
      // move window
      maxs.add(r++);
      result[l++] = nums[maxs.peekFirst()];

      // remove elements now out of range
      if (l > maxs.peekFirst()) {
        maxs.removeFirst();
      }
    }
    return result;
  }
}
