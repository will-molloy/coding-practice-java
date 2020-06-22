package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/is-subsequence>https://leetcode.com/problems/is-subsequence</a>
 *
 * <p>Runtime: O(t)
 *
 * <p>Space: O(1)
 *
 * <p>Key: separate pointer for s and t.
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
