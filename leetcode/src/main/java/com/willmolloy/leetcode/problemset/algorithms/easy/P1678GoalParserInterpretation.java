package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/goal-parser-interpretation>https://leetcode.com/problems/goal-parser-interpretation/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: {@link String#replaceAll}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1678GoalParserInterpretation {

  public String interpret(String command) {
    return command.replaceAll("[(][)]", "o").replaceAll("[(]al[])]", "al");
  }
}
