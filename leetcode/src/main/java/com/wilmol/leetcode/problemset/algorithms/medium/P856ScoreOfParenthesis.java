package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/score-of-parentheses>https://leetcode.com/problems/score-of-parentheses/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Count every "()", track depth to know what its worth (2<sup>depth</sup>).
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P856ScoreOfParenthesis {

  public int scoreOfParentheses(String s) {
    int result = 0;

    int depth = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        depth++;
      } else {
        depth--;
        if (s.charAt(i - 1) == '(') {
          result += 1 << depth;
        }
      }
    }
    return result;
  }
}
