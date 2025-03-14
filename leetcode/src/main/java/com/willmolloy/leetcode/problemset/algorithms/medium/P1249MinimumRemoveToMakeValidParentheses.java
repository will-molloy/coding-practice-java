package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses>https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Stack to track valid/invalid (balanced/unbalanced) parentheses. Placeholder removal
 * character.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1249MinimumRemoveToMakeValidParentheses {

  public String minRemoveToMakeValid(String s) {
    // to hold result (and mutate s efficiently)
    char[] result = s.toCharArray();
    // to hold position of unbalanced open parentheses
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    // process string and closing ')' for removal
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.add(i);
      }
      if (s.charAt(i) == ')') {
        if (stack.isEmpty()) {
          // no matching open '(', mark for removal
          result[i] = '*';
        } else {
          // matching open parentheses, remove from stack as we want to keep it
          stack.pop();
        }
      }
    }

    // process open '(' for removal (anything left in the stack)
    while (!stack.isEmpty()) {
      result[stack.pop()] = '*';
    }

    return new String(result).replaceAll("\\*", "");
  }
}
