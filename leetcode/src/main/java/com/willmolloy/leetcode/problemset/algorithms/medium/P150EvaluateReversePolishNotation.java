package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/evaluate-reverse-polish-notation>https://leetcode.com/problems/evaluate-reverse-polish-notation/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Stack.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P150EvaluateReversePolishNotation {

  // CHECKSTYLE IGNORE AbbreviationAsWordInName FOR NEXT 1 LINES
  public int evalRPN(String[] tokens) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (String s : tokens) {
      if (!s.matches("[+\\-*/]")) {
        stack.push(Integer.parseInt(s));
        continue;
      }
      int i1 = stack.pop();
      int i2 = stack.pop();
      switch (s) {
        case "+":
          stack.push(i2 + i1);
          break;
        case "-":
          stack.push(i2 - i1);
          break;
        case "*":
          stack.push(i2 * i1);
          break;
        case "/":
          stack.push(i2 / i1);
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
    return stack.peek();
  }
}
