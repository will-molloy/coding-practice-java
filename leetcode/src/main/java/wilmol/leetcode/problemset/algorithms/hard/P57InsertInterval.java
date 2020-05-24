package wilmol.leetcode.problemset.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wilmol on 2020-04-18.
 *
 * <p><a
 * href=https://leetcode.com/problems/insert-interval>https://leetcode.com/problems/insert-interval</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1) (O(n) including result list, used list because Java array api is ugly (EJ 28))
 *
 * <p>Key: Checking if {@code intervals[i]} can be merged into {@code newInterval} and if {@code
 * newInterval} can be merged into {@code intervals[i]} (i.e. need to check both, not just one).
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P56MergeIntervals
 * @see wilmol.leetcode.problemset.algorithms.medium.P986IntervalListIntersections
 */
class P57InsertInterval {

  // TODO more concise code?
  //  Imo this is easier to understand and shows the cases/thought process well

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    List<int[]> result = new ArrayList<>();
    if (n == 0) {
      // won't enter for loop so need to add here
      result.add(newInterval);
    }

    for (int i = 0; i < n; i++) {
      if (i == 0 && newInterval[1] < intervals[i][0]) {
        // insert 0, no merge
        result.add(newInterval);
        result.addAll(Arrays.asList(intervals));
        break;
      }
      if (newInterval[1] < intervals[i][0] && newInterval[0] > intervals[i - 1][1]) {
        // insert middle, no merge
        result.add(newInterval);
        result.addAll(Arrays.asList(intervals).subList(i, n));
        break;
      }

      if ((newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1])
          || (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1])
          || (intervals[i][0] >= newInterval[0] && intervals[i][0] <= newInterval[1])
          || (intervals[i][1] >= newInterval[0] && intervals[i][1] <= newInterval[1])) {
        // merging
        while (i < n
            && ((newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1])
                || (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1])
                || (intervals[i][0] >= newInterval[0] && intervals[i][0] <= newInterval[1])
                || (intervals[i][1] >= newInterval[0] && intervals[i][1] <= newInterval[1]))) {
          newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
          newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
          i++;
        }
        result.add(newInterval);
        result.addAll(Arrays.asList(intervals).subList(i, n));
        break;
      }

      result.add(intervals[i]);
      if (i == n - 1) {
        // insert last, no merge
        result.add(newInterval);
      }
    }

    return result.toArray(new int[0][0]);
  }
}
