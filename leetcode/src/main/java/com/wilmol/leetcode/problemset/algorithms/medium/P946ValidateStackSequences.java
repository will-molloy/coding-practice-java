package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/validate-stack-sequences>https://leetcode.com/problems/validate-stack-sequences/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Greedy - pop if possible.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P946ValidateStackSequences {

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
