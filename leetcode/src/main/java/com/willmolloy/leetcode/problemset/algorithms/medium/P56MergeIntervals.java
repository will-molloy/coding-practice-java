package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/merge-intervals>https://leetcode.com/problems/merge-intervals</a>
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P57InsertInterval
 * @see P435NonOverlappingIntervals
 * @see P452MinimumNumberOfArrowsToBurstBalloons
 * @see P763PartitionLabels
 * @see P986IntervalListIntersections
 * @see P1288RemoveCoveredIntervals
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P56MergeIntervals {

  int[][] merge(int[][] intervals);

  /**
   * My solution. Each iteration merge the next interval encountered into the result. Basically
   * brute force.
   *
   * <p>Runtime: O(n<sup>3</sup>) TODO ??? If you keep merging then the result set gets smaller each
   * time so never 'n' iteration (similar to insertion sort, where you have less and less elements
   * to add in, which is O(n<sup>2</sup>)). Need to figure out average size of 'result'. Leetcode
   * also has a graph algorithm which is O(n<sup>2</sup>)... maybe same as that?
   *
   * <p>Key idea: breaking out to a separate method (getMergeIndex) to continue the merging logic
   * for an unknown amount of iterations.
   */
  final class MergeIntervalsInEncounterOrder implements P56MergeIntervals {

    public int[][] merge(int[][] intervals) {

      // basically insertion sort but instead of inserting elements they're merged into the result

      List<int[]> result = new ArrayList<>();

      // loop each interval (O(n) n = intervals.size())
      for (int[] interval : intervals) {

        // keep merging 'interval' against current result set
        // ??? O(n) ??? n = result.size(), which is proportional to intervals.size()?
        while (true) {
          int mergeIndex = getMergeIndex(result, interval);
          if (mergeIndex != -1) {
            // can merge
            // remove the interval which is being merged on
            int[] toMerge = result.remove(mergeIndex);
            // update current interval to the merged interval
            // don't add yet because may merge in more intervals
            interval =
                new int[] {Math.min(toMerge[0], interval[0]), Math.max(toMerge[1], interval[1])};
          } else {
            // can't merge
            // add and continue to next interval
            result.add(interval);
            break;
          }
        }
      }
      return result.toArray(new int[][] {});
    }

    // ??? O(n) ??? n = result.size(), which is proportional to intervals.size()?
    private int getMergeIndex(List<int[]> result, int[] interval) {
      for (int i = 0; i < result.size(); i++) {
        if (canMerge(result.get(i), interval)) {
          return i;
        }
      }
      return -1;
    }

    // O(1)
    private boolean canMerge(int[] a, int[] b) {
      return contains(a[0], b) || contains(a[1], b) || contains(b[0], a) || contains(b[1], a);
    }

    // O(1)
    private boolean contains(int x, int[] range) {
      return x >= range[0] && x <= range[1];
    }
  }

  /**
   * Optimal solution (from leetcode solution page). Sort intervals by start value before merging.
   *
   * <p>Runtime: O(n log n), Space: O(1) (depends on sorting implementation).
   *
   * <p>Key idea: consider what happens if you sort first!
   */
  final class SortFirst implements P56MergeIntervals {

    public int[][] merge(int[][] intervals) {
      // sort intervals by their start value (O(n log n))
      // then each set of intervals that can be merged will be in a contiguous 'run' in the list
      List<int[]> sortedIntervals =
          Arrays.stream(intervals).sorted(Comparator.comparingInt(arr -> arr[0])).toList();

      // add each interval in sorted encounter order (O(n))
      List<int[]> result = new ArrayList<>();
      for (int[] interval : sortedIntervals) {
        if (result.isEmpty() || result.getLast()[1] < interval[0]) {
          // interval does not overlap with most recently added interval
          // so add as new (possibly merged on later) interval
          result.add(interval);
        } else {
          // otherwise there is overlap
          // merge into most recently added interval
          result.getLast()[1] =
              Math.max(result.getLast()[1], interval[1]);
        }
      }
      return result.toArray(new int[][] {});
    }
  }
}
