package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/longest-uncommon-subsequence-i>https://leetcode.com/problems/longest-uncommon-subsequence-i/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(min(a, b)) (cost of {@link String#equals})
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: Supersequence can't be a subsequence (unless it's equal).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P517LongestUncommonSubsequence {

  public int findLusLength(String a, String b) {
    if (a.equals(b)) {
      return -1;
    }
    return Math.max(a.length(), b.length());
  }
}
