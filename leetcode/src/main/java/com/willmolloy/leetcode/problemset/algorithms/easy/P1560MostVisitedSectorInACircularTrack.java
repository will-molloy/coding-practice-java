package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/most-visited-sector-in-a-circular-track>https://leetcode.com/problems/most-visited-sector-in-a-circular-track/</a>
 *
 * <p>Runtime: O(n * log(n)) TODO O(n) is possible but not as elegant (do [1, end] + [start, n] for
 * the case start > end to avoid sort)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Only start/end sectors matter, since that's effectively where the runners must
 * travel, everything else is ran in a loop and visited once fewer.
 *
 * <p>E.g. n = 4 with rounds = [1, 3, 1, 2] is really [1, 2, 3, 4, 1, 2] = [1, 2]
 *
 * <p>E.g.2 n = 3 with rounds = [3, 2, 1] is really [3, 1, 2, 3, 1] = [3, 1]
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1560MostVisitedSectorInACircularTrack {

  public List<Integer> mostVisited(int n, int[] rounds) {
    int start = rounds[0];
    int end = rounds[rounds.length - 1];

    List<Integer> sectors = new ArrayList<>();
    for (int i = start; i != end; i = i % n + 1) {
      sectors.add(i);
    }
    sectors.add(end);

    sectors.sort(Comparator.naturalOrder());
    return sectors;
  }
}
