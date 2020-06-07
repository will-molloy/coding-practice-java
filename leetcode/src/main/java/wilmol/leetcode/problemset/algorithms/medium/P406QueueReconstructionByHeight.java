package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wilmol on 2020-06-07.
 *
 * <p><a
 * href=https://leetcode.com/problems/queue-reconstruction-by-height>https://leetcode.com/problems/queue-reconstruction-by-height/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Sort before starting insertion procedure. Don't reconstruct in-place, easier to insert
 * via {@code ArrayList}.
 */
class P406QueueReconstructionByHeight {

  public int[][] reconstructQueue(int[][] people) {
    // sort by h (largest first) and k (smallest first)
    // e.g. input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    // after sorting: [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
    Arrays.sort(
        people,
        Comparator.comparingInt((int[] p) -> p[0]).reversed().thenComparingInt((int[] p) -> p[1]));

    // now we can start inserting elements into their final position
    // starting with the largest heights, insert each element at point k
    // this guarantees k people with height >= h in front of them (as we've already sorted by
    // height descending)

    // each iteration the result will be a valid reconstruction and this invariant will continue to
    // hold because when we insert smaller heights the larger heights will shift right

    // e.g. input = [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
    // result after i = 0: [[7,0]]
    // result after i = 1: [[7,0], [7,1]]
    // result after i = 2: [[7,0], [6,1], [7,1]]
    // result after i = 3: [[5,0], [7,0], [6,1], [7,1]]
    // result after i = 4: [[5,0], [7,0], [5,2], [6,1], [7,1]]
    // result after i = 5: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

    List<int[]> result = new ArrayList<>();
    for (int[] p : people) {
      result.add(p[1], p);
    }

    return result.toArray(new int[0][0]);
  }
}
