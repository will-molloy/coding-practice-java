package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/asteroid-collision>https://leetcode.com/problems/asteroid-collision/</a>
 *
 * <p>Runtime: O(n) (push/pop each asteroid at most once)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Consider what happens when adding a new asteroid to the right of a sequence of
 * stable asteroids, a stack is natural.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P735AsteroidCollision {

  public int[] asteroidCollision(int[] a) {
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int next : a) {
      if (next > 0) {
        // next is moving right, it can't be destroyed nor destroy anything (in this iteration)
        stack.push(next);
        continue;
      }

      // next is moving left

      while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -next) {
        // existing asteroids moving right are destroyed by next
        stack.pop();
      }

      if (!stack.isEmpty() && stack.peek() > 0) {
        if (stack.peek() == -next) {
          // both next and existing asteroid moving right are destroyed
          stack.pop();
        }
        // existing asteroid moving right destroys next
      } else {
        // no existing asteroid or existing asteroid moving left
        stack.push(next);
      }
    }

    int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }
}
