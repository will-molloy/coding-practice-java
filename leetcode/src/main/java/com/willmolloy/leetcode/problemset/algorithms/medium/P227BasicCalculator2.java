package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/basic-calculator-ii>https://leetcode.com/problems/basic-calculator-ii/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Stack.
 *
 * @see P394DecodeString
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P227BasicCalculator2 {

  public int calculate(String s) {
    s = s.replaceAll("\\s", "");

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    // begin with +0
    int number = 0;
    char operation = '+';

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Character.isDigit(c)) {
        int digit = c - '0';
        number = number * 10 + digit;
      }

      // run on final iteration to use final op
      if (!Character.isDigit(c) || i == s.length() - 1) {
        switch (operation) {
          case '+':
            stack.push(number);
            break;
          case '-':
            stack.push(-number);
            break;
          case '*':
            stack.push(stack.pop() * number);
            break;
          case '/':
            stack.push(stack.pop() / number);
            break;
          default:
        }
        number = 0;
        operation = c;
      }
    }
    return stack.stream().reduce(0, Integer::sum);
  }
}
