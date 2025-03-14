package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/find-the-most-competitive-subsequence>https://leetcode.com/problems/find-the-most-competitive-subsequence/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n) (NOT O(k), possibly never remove from the deque)
 *
 * <p>Key idea: Monotonic queue (e.g. 1xx always beats 21x, so remove the 2), but also ensuring it
 * will end with at least k elements.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1673FindTheMostCompetitiveSubsequence {

  public int[] mostCompetitive(int[] nums, int k) {
    int n = nums.length;

    // monotonically increasing
    Deque<Integer> q = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      // ensure monotonically increasing queue AND have enough to end with at least k elements
      int remainingIterations = n - i;
      int remainingSize = k - q.size();
      while (!q.isEmpty() && q.peekLast() > nums[i] && remainingIterations > remainingSize) {
        q.removeLast();
        remainingSize++;
      }
      q.addLast(nums[i]);
    }

    int[] a = new int[k];
    for (int i = 0; i < a.length; i++) {
      a[i] = q.removeFirst();
    }
    return a;
  }
}
