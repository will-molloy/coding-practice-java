package com.wilmol.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-score-of-a-good-subarray>https://leetcode.com/problems/maximum-score-of-a-good-subarray/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Want to maximise the subarray size and maximise the subarray minimum.
 *
 * <p>Start with {@code nums[k]} and grow out until entire {@code nums} is considered. When moving
 * {@code i} and {@code j}, grow towards the larger of the two (greedy), this way we get a larger
 * array with a lower chance of a smaller min.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1793MaximumScoreOfAGoodSubarray {

  // during contest did not have the first two conditions
  // (which move i when j is finished and vice versa)
  // so it would exit the loop before the entire array was considered

  public int maximumScore(int[] nums, int k) {
    int n = nums.length;

    // start with nums[k]
    int i = k;
    int j = k;
    int subarrayMin = nums[k];
    int subarraySize = 1;

    int maxScore = nums[k];

    // grow out until entire array is considered
    while (subarraySize < n) {
      if (i == 0) {
        // finished moving i, must move j
        j++;
      } else if (j == n - 1) {
        // finished moving j, must move i
        i--;
      } else if (nums[i - 1] > nums[j + 1]) {
        // greedy choice: move towards larger of nums[i] and nums[j]
        i--;
      } else {
        j++;
      }
      // since we move one step each iteration, can maintain min like this (don't need TreeSet)
      subarrayMin = Math.min(Math.min(nums[i], nums[j]), subarrayMin);
      subarraySize++;
      maxScore = Math.max(subarrayMin * subarraySize, maxScore);
    }
    return maxScore;
  }
}
