package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/reach-a-number>https://leetcode.com/problems/reach-a-number/</a>
 *
 * <p>Runtime: O(sqrt(target))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Move left/right using numbers [1, k].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P754ReachANumber {

  public int reachNumber(int target) {
    target = Math.abs(target);

    int k = 0;
    while (target > 0) {
      target -= ++k;
    }

    if (target % 2 == 0) {
      return k;
    } else {
      return k + 1 + k % 2;
    }
  }
}
