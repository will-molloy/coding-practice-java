package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/count-unhappy-friends>https://leetcode.com/problems/count-unhappy-friends/</a>
 *
 * <p>Runtime: O({@code pairs} + {@code preferences}<sup>2</sup> + {@code n}<sup>2</sup>) = O({@code
 * n}<sup>2</sup>)
 *
 * <p>Extra memory: O({@code pairs} + {@code preferences}<sup>2</sup>) = O({@code n}<sup>2</sup>)
 *
 * <p>Key: Simulate the problem; "count x's where there exists a v such that ..." (see full problem
 * description). Used hashmaps to make pair/preference lookup constant.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1583CountUnhappyFriends {

  public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    Map<Integer, Integer> pair = new HashMap<>();
    for (int[] p : pairs) {
      pair.put(p[0], p[1]);
      pair.put(p[1], p[0]);
    }

    // LOWER IS BETTER
    Map<Integer, Map<Integer, Integer>> preference = new HashMap<>();
    for (int i = 0; i < preferences.length; i++) {
      preference.put(i, new HashMap<>());
      for (int j = 0; j < preferences[i].length; j++) {
        preference.get(i).put(preferences[i][j], j);
      }
    }

    int count = 0;
    for (int x = 0; x < n; x++) {
      int y = pair.get(x);
      for (int u = 0; u < n; u++) {
        if (u == x || u == y) {
          continue;
        }
        int v = pair.get(u);
        if (preference.get(x).get(u) < preference.get(x).get(y)
            && preference.get(u).get(x) < preference.get(u).get(v)) {
          count++;
          // break so don't double count x
          break;
        }
      }
    }
    return count;
  }
}
