package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/is-subsequence>https://leetcode.com/problems/is-subsequence</a>
 *
 * <p>Runtime: O(t)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: separate pointer for s and t.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P392IsSubsequence {

  public boolean isSubsequence(String s, String t) {
    int sI = 0;
    int tI = 0;
    while (sI < s.length() && tI < t.length()) {
      if (s.charAt(sI) == t.charAt(tI)) {
        sI++;
      }
      tI++;
    }
    return sI == s.length();
  }
}
