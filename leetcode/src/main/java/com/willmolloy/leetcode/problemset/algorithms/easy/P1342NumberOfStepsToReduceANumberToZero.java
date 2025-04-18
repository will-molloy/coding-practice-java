package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero>https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero</a>
 *
 * <p>Runtime: O(log n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: coding up problem steps
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1342NumberOfStepsToReduceANumberToZero {

  // preconditions:
  // n >= 0

  public int numberOfSteps(int n) {
    int steps = 0;
    while (n != 0) {
      n = next(n);
      steps += 1;
    }
    return steps;
  }

  private int next(int n) {
    if (isEven(n)) {
      return n / 2;
    } else {
      return n - 1;
    }
  }

  private boolean isEven(int n) {
    return n % 2 == 0;
  }
}
