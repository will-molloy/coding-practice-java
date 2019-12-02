package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2019-12-02.
 *
 * <p><a
 * href=https://leetcode.com/problems/merge-intervals>https://leetcode.com/problems/merge-intervals</a>
 *
 * <p>Runtime: O(n<sup>3</sup>) TODO ??? If you keep merging then the result set gets smaller each
 * time so never 'n' iterations. Worst case ???: result = [[1,2], [3,4], [5,6]] interval = [0,7] ->
 * have to merge into 1 ([0,7]). Similar to insertion sort which is O(n<sup>2</sup>) ??? Need to
 * figure out average size of 'result'.
 *
 * <p>TODO can be done in O(nlogn) with sort? See leetcode discussions. This still ran faster than
 * 95%...
 *
 * <p>Key: breaking out to a separate method (getMergeIndex) to continue the merging logic for an
 * unknown amount of iterations.
 */
class P56MergeIntervals {

  public int[][] merge(int[][] intervals) {
    // basically insertion sort but instead of inserting elements they're merged in

    List<int[]> result = new ArrayList<>();

    // loop each interval O(n) n = intervals.size()
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
