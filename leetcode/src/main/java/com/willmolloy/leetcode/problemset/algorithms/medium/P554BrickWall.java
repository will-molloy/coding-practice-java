package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href=https://leetcode.com/problems/brick-wall>https://leetcode.com/problems/brick-wall</a>
 *
 * <p>Runtime: O(height * width)
 *
 * <p>Space: O(width) (map size depends only on number of columns as these determine the prefix sums
 * which are the map keys)
 *
 * <p>Key idea: Clear that it was best to find column with most gaps and that prefix sums and
 * hashtable would help with that. Main fix needed was setting {@code maxGaps} to {@code 0}
 * initially (rather than {@code INT_MIN}) to cover the case when you have to cross a brick in every
 * row.
 *
 * @see <a
 *     href=https://en.wikipedia.org/wiki/Prefix_sum>https://en.wikipedia.org/wiki/Prefix_sum</a>
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P554BrickWall {

  public int leastBricks(List<List<Integer>> wall) {
    // map(i) = number of gaps at column i
    Map<Integer, Integer> map = new HashMap<>();

    // compute prefix/cumulative sum of bricks in each row and store frequency
    // this will populate the map as described above
    for (List<Integer> row : wall) {
      int brickSum = 0;
      // don't care about edges (brickSum = 0, or brickSum = sum(row) (so leave out last brick))
      for (int brickI = 0; brickI < row.size() - 1; brickI++) {
        int brick = row.get(brickI);
        brickSum += brick;
        map.merge(brickSum, 1, Integer::sum);
      }
    }

    // find most gaps
    int maxGaps = 0;
    for (int gaps : map.values()) {
      maxGaps = Math.max(maxGaps, gaps);
    }

    // return min bricks crossed (i.e. height - most gaps)
    return wall.size() - maxGaps;
  }
}
