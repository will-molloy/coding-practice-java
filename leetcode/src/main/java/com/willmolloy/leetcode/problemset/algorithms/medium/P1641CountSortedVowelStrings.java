package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/count-sorted-vowel-strings>https://leetcode.com/problems/count-sorted-vowel-strings/</a>
 *
 * <p>Runtime: O(5<sup>n</sup>) TODO can improve
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: DFS brute force.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1641CountSortedVowelStrings {

  private final List<Character> list = List.of('a', 'e', 'i', 'o', 'u');

  private int count;

  public int countVowelStrings(int n) {
    count = 0;
    dfs(new StringBuilder(), n);
    return count;
  }

  private void dfs(StringBuilder s, int n) {
    if (s.length() == n) {
      count++;
      return;
    }

    for (char c : list) {
      if (s.length() == 0 || c >= s.charAt(s.length() - 1)) {
        s.append(c);
        dfs(s, n);
        s.deleteCharAt(s.length() - 1);
      }
    }
  }
}
