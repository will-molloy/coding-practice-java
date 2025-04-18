package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings>https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/</a>
 *
 * <p>Runtime: O(2<sup>n</sup>)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Recursively try all the combinations (DFS backtracking).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

  private int max;

  public int maxUniqueSplit(String s) {
    max = 1;
    dfs(new HashSet<>(), s);
    return max;
  }

  private void dfs(Set<String> subs, String tail) {
    if (tail.isEmpty()) {
      max = Math.max(max, subs.size());
    }
    for (int i = 1; i <= tail.length(); i++) {
      String head = tail.substring(0, i);
      if (subs.add(head)) {
        dfs(subs, tail.substring(i));
        // backtrack
        subs.remove(head);
      }
    }
  }
}
