package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a
 * href=https://leetcode.com/problems/remove-covered-intervals>https://leetcode.com/problems/remove-covered-intervals/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Initially sort by start ascending and end descending such that 'covering' intervals
 * (those which cover other intervals) appear earlier in the array. Can then track the current
 * 'covering' interval ({@code anchor}).
 *
 * @see P56MergeIntervals
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P57InsertInterval
 * @see P435NonOverlappingIntervals
 * @see P452MinimumNumberOfArrowsToBurstBalloons
 * @see P763PartitionLabels
 * @see P986IntervalListIntersections
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1288RemoveCoveredIntervals {

  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(
        intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> -a[1]));

    int anchor = 0;
    int count = 1;

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][1] > intervals[anchor][1]) {
        anchor = i;
        count++;
      }
    }
    return count;
  }
}
