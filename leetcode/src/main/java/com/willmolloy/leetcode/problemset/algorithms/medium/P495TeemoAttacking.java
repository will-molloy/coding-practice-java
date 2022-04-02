package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/teemo-attacking>https://leetcode.com/problems/teemo-attacking/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Take the min of time between attacks and poison duration; that's how long the poison is
 * per attack by definition.
 *
 * @see P56MergeIntervals
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P495TeemoAttacking {

  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int n = timeSeries.length;
    if (n == 0 || duration == 0) {
      return 0;
    }

    int overallDuration = 0;
    for (int i = 0; i < n; i++) {
      if (i < n - 1) {
        overallDuration += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
      } else {
        overallDuration += duration;
      }
    }
    return overallDuration;
  }
}
