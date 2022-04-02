package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/longest-valid-parentheses>https://leetcode.com/problems/longest-valid-parentheses</a>
 *
 * <p>Runtime: O(n)
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P20ValidParenthesis
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P32LongestValidParenthesis {

  public int longestValidParentheses(String s) {
    int max = 0;
    // can use stack to know if scanned string so far is valid and update maximums in one pass
    Deque<Integer> stack = new ArrayDeque<>();
    // push -1 as a dummy starting/boundary point
    stack.push(-1);

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(') {
        // open bracket, push index - to know where sequence started
        stack.push(i);
      } else {
        // close bracket, redetermine maximum (if valid)

        // pop topmost element (i.e. the pairing open bracket (if present else dummy starting point)
        // then the topmost element on the stack will be index of where this valid sequence started
        stack.pop();

        if (!stack.isEmpty()) {
          // stack isn't empty, so starting point is present, can update maximum
          int lengthOfCurrentValidParenthesis = i - stack.peek();
          max = Math.max(max, lengthOfCurrentValidParenthesis);
        } else {
          // stack is empty, need new dummy starting point
          // use current index, effectively '-1' as if we were starting over from next index
          stack.push(i);
        }
      }
    }
    return max;
  }
}
