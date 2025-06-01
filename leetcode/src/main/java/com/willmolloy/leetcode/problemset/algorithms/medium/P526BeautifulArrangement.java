package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/beautiful-arrangement>https://leetcode.com/problems/beautiful-arrangement/</a>
 *
 * <p>Runtime: O(n!) (worst case did all permutations)
 *
 * <p>Extra memory: O(n) (recursion depth)
 *
 * <p>Key idea: Try all the permutations - can prune the search by checking if an element is good at
 * the time of adding rather than after building the whole list.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P526BeautifulArrangement {

  private int count;

  public int countArrangement(int n) {
    count = 0;
    dfs(new ArrayList<>(), n);
    return count;
  }

  private void dfs(List<Integer> list, int n) {
    if (list.size() == n) {
      count++;
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (list.contains(i)) {
        continue;
      }

      // check element is good to add now rather than after building the whole list
      int index = list.size() + 1;
      if (!(i % index == 0 || index % i == 0)) {
        continue;
      }

      list.add(i);
      dfs(list, n);
      list.removeLast();
    }
  }
}
