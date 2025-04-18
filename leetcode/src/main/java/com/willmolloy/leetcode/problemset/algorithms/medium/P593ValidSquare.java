package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/valid-square>https://leetcode.com/problems/valid-square/</a>
 *
 * <p>Runtime: O(1) - fixed input size
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Square can be rotated. Square has 4 equal sides, 2 equal diagonals.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P593ValidSquare {

  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    List<int[]> list = List.of(p1, p2, p3, p4);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        map.merge(distance(list.get(i), list.get(j)), 1, Integer::sum);
      }
    }

    // check no overlapping points (no distance of 0)
    // then check for square: 4 equal sides, 2 equal diagonals
    return !map.containsKey(0)
        && map.keySet().size() == 2
        && Set.copyOf(map.values()).equals(Set.of(2, 4));
  }

  private int distance(int[] a, int[] b) {
    int x = a[0] - b[0];
    int y = a[1] - b[1];
    return x * x + y * y;
  }
}
