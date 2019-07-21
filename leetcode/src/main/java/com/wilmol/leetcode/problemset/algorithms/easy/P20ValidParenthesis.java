package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Will on 2019-07-21 at 21:29.
 *
 * <p><a
 * href=https://leetcode.com/problems/valid-parentheses>https://leetcode.com/problems/valid-parentheses</a>
 *
 * <p>Runtime: O(n)
 */
class P20ValidParenthesis {

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
        if (stack.isEmpty() || c != stack.pop()) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
