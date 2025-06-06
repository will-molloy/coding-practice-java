package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/validate-stack-sequences>https://leetcode.com/problems/validate-stack-sequences/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Greedy - pop if possible.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P946ValidateStackSequences {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    int popI = 0;
    for (int push : pushed) {
      stack.push(push);
      while (!stack.isEmpty() && stack.peek() == popped[popI]) {
        stack.pop();
        popI++;
      }
    }
    return stack.isEmpty();
  }
}
