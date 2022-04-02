package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/baseball-game>https://leetcode.com/problems/baseball-game</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: stack (LIFO)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P682BaseballGame {

  public int calPoints(String[] ops) {
    // use stack so have access to most recent rounds first
    Deque<Integer> stack = new ArrayDeque<>();
    for (String op : ops) {
      if (op.equals("+")) {
        // case 2, sum of last two rounds
        int last = stack.pop();
        int secondLast = stack.peek();
        stack.push(last);
        stack.push(last + secondLast);
      } else if (op.equals("D")) {
        // case 3, double last round
        int last = stack.peek();
        stack.push(last * 2);
      } else if (op.equals("C")) {
        // case 4, invalidate last round
        stack.pop();
      } else {
        // case 1, direct number of points
        stack.push(Integer.valueOf(op));
      }
    }

    int score = 0;
    for (int i : stack) {
      score += i;
    }
    return score;
  }
}
