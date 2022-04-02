package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/path-crossing>https://leetcode.com/problems/path-crossing/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Duplicate detection; track previous locations in set.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1496PathCrossing {

  public boolean isPathCrossing(String path) {
    Set<List<Integer>> set = new HashSet<>();
    set.add(Arrays.asList(0, 0));
    int x = 0;
    int y = 0;

    for (char c : path.toCharArray()) {
      switch (c) {
        case 'N':
          y++;
          break;
        case 'S':
          y--;
          break;
        case 'E':
          x++;
          break;
        case 'W':
          x--;
          break;
        default:
          throw new IllegalArgumentException(path);
      }
      if (!set.add(Arrays.asList(x, y))) {
        return true;
      }
    }
    return false;
  }
}
