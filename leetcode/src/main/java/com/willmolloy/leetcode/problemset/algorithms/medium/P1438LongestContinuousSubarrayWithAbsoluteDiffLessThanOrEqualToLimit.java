package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit>https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/</a>
 *
 * <p>Key idea: Two pointers (growing and shrinking subsequence) and {@link java.util.Deque} to
 * track the min/max element in the dynamic subarray.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P239SlidingWindowMaximum
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

  int longestSubarray(int[] nums, int limit);

  /**
   * Solution which got TLE.
   *
   * <p>Runtime: O(n<sup>2</sup>)
   *
   * <p>Extra space: O(1)
   */
  class TimeLimitExceeded
      implements P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    @Override
    public int longestSubarray(int[] nums, int limit) {
      int n = nums.length;
      int longest = 1;

      // try all subarrays [l, r]
      for (int l = 0; l < n; l++) {
        int max = nums[l];
        int min = nums[l];
        for (int r = l; r < n; r++) {
          max = Math.max(max, nums[r]);
          min = Math.min(min, nums[r]);
          // max diff is max element - min element
          if (max - min > limit) {
            break;
          }
          longest = Math.max(longest, r - l + 1);
        }
      }
      return longest;
    }
  }

  /**
   * Solution which got accepted.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra space: O(n)
   */
  class Accepted implements P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    @Override
    public int longestSubarray(int[] nums, int limit) {
      int n = nums.length;
      int longest = 1;

      // initially start with [l, r] = [0, 0]
      // grow (move r out) if subarray is valid to find larger subarray
      // shrink (move l in) if subarray is invalid to find valid subarray
      int l = 0;
      int r = 0;

      // maintain queues of nums indices (in range [l, r]) in ascending order
      // maintain front of queue as index of min element
      ArrayDeque<Integer> mins = new ArrayDeque<>();
      // maintain front of queue as index of max element
      ArrayDeque<Integer> maxs = new ArrayDeque<>();
      // this way can get max diff of the subarray in O(1) time
      // AND update these queues easily when l/r move

      while (r < n) {
        // remove from end of queue if larger than new num
        // so maintain invariant front of queue is index min element AND is sorted ascending order
        // (elements removed will never be the min in the subarray since r is only moved forward)
        while (!mins.isEmpty() && nums[mins.peekLast()] >= nums[r]) {
          mins.removeLast();
        }
        mins.addLast(r);

        // remove from end of queue if smaller than new num
        // so maintain invariant front of queue is index max element AND is sorted ascending order
        // (elements removed will never be the max in the subarray since r is only moved forward)
        while (!maxs.isEmpty() && nums[maxs.peekLast()] <= nums[r]) {
          maxs.removeLast();
        }
        maxs.addLast(r);

        while (nums[maxs.peekFirst()] - nums[mins.peekFirst()] > limit) {
          // shrink until subarray is valid
          l++;
          // remove indices now out of range
          while (l > mins.peekFirst()) {
            mins.removeFirst();
          }
          while (l > maxs.peekFirst()) {
            maxs.removeFirst();
          }
        }

        longest = Math.max(longest, r - l + 1);
        // grow to find if larger subarray is possible
        r++;
      }
      return longest;
    }
  }
}
