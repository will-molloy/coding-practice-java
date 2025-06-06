package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses>https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Track depth as you go.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1614MaximumNestingDepthOfTheParenthesis {

  public int maxDepth(String s) {
    int depth = 0;
    int max = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        depth++;
      }
      if (c == ')') {
        depth--;
      }
      max = Math.max(max, depth);
    }
    return max;
  }
}
