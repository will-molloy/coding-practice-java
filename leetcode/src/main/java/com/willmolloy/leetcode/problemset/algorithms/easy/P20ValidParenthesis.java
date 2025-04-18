package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/valid-parentheses>https://leetcode.com/problems/valid-parentheses</a>
 *
 * <p>Runtime: O(n)
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P32LongestValidParenthesis
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P20ValidParenthesis {

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else {
        // c is closing bracket, which must match the most recent open bracket
        // which a FIFO (stack) holds in pop() method

        // if single bracket type - dont need to check bracket type matches
        // actually, could just keep a count of open brackets (no stack needed)
        if (stack.isEmpty() || c != stack.pop()) {
          return false;
        }
      }
    }
    // ensure all open brackets are closed
    return stack.isEmpty();
  }
}
