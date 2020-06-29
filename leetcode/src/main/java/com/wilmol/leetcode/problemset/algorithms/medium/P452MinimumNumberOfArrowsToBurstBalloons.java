package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons>https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/</a>
 *
 * <p>Runtime: O(n log(n))
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Sort by end rather than start to determine which intervals overlap.
 *
 * @see <a href=https://en.wikipedia.org/wiki/Activity_selection_problem>Activity selection problem
 *     (classic greedy algorithm problem)</a>
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P452MinimumNumberOfArrowsToBurstBalloons {

  public int findMinArrowShots(int[][] points) {
    // number of overlapping intervals

    int n = points.length;

    // sort by end of interval
    Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

    int arrows = 0;
    for (int i = 0; i < n; ) {
      int j = i + 1;
      // shoot arrow at end of interval to cover as many intervals as possible (greedy choice)
      // this is optimal because we take as many intervals as we can until they're disjoint
      while (j < n && points[i][1] >= points[j][0]) {
        j++;
      }
      i = j;
      arrows++;
    }
    return arrows;
  }
}
