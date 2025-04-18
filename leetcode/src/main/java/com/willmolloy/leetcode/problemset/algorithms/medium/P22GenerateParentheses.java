package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/generate-parentheses>https://leetcode.com/problems/generate-parentheses</a>
 *
 * <p>Runtime: TODO O() ?? some x^n
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P22GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    return generateParenthesis(new ArrayList<>(), "", 0, 0, n);
  }

  private List<String> generateParenthesis(
      List<String> results, String temp, int open, int closed, int n) {
    if (temp.length() == n * 2) {
      results.add(temp);
    }
    // add open parenthesis first in DFS manner until limit (size/2) is reached
    if (open < n) {
      generateParenthesis(results, temp + "(", open + 1, closed, n);
    }
    // only add closed parenthesis after enough open parenthesis are added
    if (closed < open) {
      generateParenthesis(results, temp + ")", open, closed + 1, n);
    }
    return results;
  }
}
