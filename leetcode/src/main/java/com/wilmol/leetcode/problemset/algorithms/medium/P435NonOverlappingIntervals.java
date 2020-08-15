package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a
 * href=https://leetcode.com/problems/non-overlapping-intervals>https://leetcode.com/problems/non-overlapping-intervals/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Sort by smallest end values (so get fewest overlaps) then skip any that overlap.
 * (Greedy.) Doesn't matter sorting the start values, will end up with same anchors (e.g. {@code [1,
 * 3]} conflicts with both {@code [1, 2]} and {@code [2, 3]} so doesn't matter which is anchor when
 * {@code [1, 3]} is encountered).
 *
 * @see P56MergeIntervals
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P57InsertInterval
 * @see P452MinimumNumberOfArrowsToBurstBalloons
 * @see P986IntervalListIntersections
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P435NonOverlappingIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

    int numSkipped = 0;
    int[] anchor = null;
    for (int[] interval : intervals) {
      if (anchor == null || interval[0] >= anchor[1]) {
        // not overlapping
        anchor = interval;
      } else {
        // overlapping
        numSkipped++;
      }
    }
    return numSkipped;
  }
}
