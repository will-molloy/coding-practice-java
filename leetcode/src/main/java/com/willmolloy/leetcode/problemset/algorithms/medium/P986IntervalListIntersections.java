package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/interval-list-intersections>https://leetcode.com/problems/interval-list-intersections/</a>
 *
 * @see P56MergeIntervals
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P57InsertInterval
 * @see P435NonOverlappingIntervals
 * @see P452MinimumNumberOfArrowsToBurstBalloons
 * @see P763PartitionLabels
 * @see P1288RemoveCoveredIntervals
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P986IntervalListIntersections {

  int[][] intervalIntersection(int[][] as, int[][] bs);

  /**
   * Quadratic solution.
   *
   * <p>Runtime: O(ab)
   *
   * <p>Extra space: O(1)
   *
   * <p>Key idea: For each range, compare (intersect) with each range in the other list.
   */
  class Quadratic implements P986IntervalListIntersections {

    @Override
    public int[][] intervalIntersection(int[][] as, int[][] bs) {
      List<int[]> result = new ArrayList<>();

      for (int[] a : as) {
        for (int[] b : bs) {
          // intersection:
          // take max of starts and min of ends
          int start = Math.max(a[0], b[0]);
          int end = Math.min(a[1], b[1]);

          if (start <= end) {
            // non-empty range
            result.add(new int[] {start, end});
          }
        }
      }
      return result.toArray(new int[0][0]);
    }
  }

  /**
   * Linear solution.
   *
   * <p>Runtime: O(a + b)
   *
   * <p>Extra space: O(1)
   *
   * <p>Key idea: Since the ranges are pairwise disjoint and sorted, use two pointers, one for each
   * list. Then can progress the pointer for the range with the smallest endpoint because it won't
   * be able to intersect anymore ranges.
   */
  class Linear implements P986IntervalListIntersections {

    @Override
    public int[][] intervalIntersection(int[][] as, int[][] bs) {
      List<int[]> result = new ArrayList<>();

      int ai = 0;
      int bi = 0;

      while (ai < as.length && bi < bs.length) {
        // intersection:
        // take max of starts and min of ends
        int start = Math.max(as[ai][0], bs[bi][0]);
        int end = Math.min(as[ai][1], bs[bi][1]);

        if (start <= end) {
          // non-empty range
          result.add(new int[] {start, end});
        }

        // the range with the smallest endpoint cannot intersect anymore ranges
        // (because the lists are pairwise disjoint and sorted)
        // e.g.
        // say a[ai] = [2, 3] and b[bi] = [2, 4]
        // then b[bi + j] (j >= 1) would have start > 4 so a[ai] would never intersect
        // therefore move pointer for this range as we're done using it
        if (as[ai][1] < bs[bi][1]) {
          ai++;
        } else {
          bi++;
        }
      }
      return result.toArray(new int[0][0]);
    }
  }
}
