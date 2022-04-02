package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-moves-to-equal-array-elements>https://leetcode.com/problems/minimum-moves-to-equal-array-elements/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Math trick to simplify the problem.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P462MinimumMovesToEqualArrayElements2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P453MinimumMovesToEqualArrayElements {

  public int minMoves(int[] nums) {
    // adding 1 to n - 1 elements is the same as subtracting 1 from 1 element
    // so the problem then becomes moves to reduce all elements to the min element

    // find min element
    int min = Integer.MAX_VALUE;
    for (int i : nums) {
      min = Math.min(min, i);
    }

    // moves = sum of distances to min element
    int moves = 0;
    for (int i : nums) {
      moves += i - min;
    }
    return moves;
  }
}
