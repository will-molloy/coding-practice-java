package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/broken-calculator>https://leetcode.com/problems/broken-calculator/</a>
 *
 * <p>Runtime: O(log(y))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Greedy and work backwards. Divide y by 2 (if even - greedy) otherwise add 1.
 *
 * <p>Working backwards works because it means we know if we can divide y by 2 (and therefore
 * multiply x by 2) - based on y's parity.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P991BrokenCalculator {

  public int brokenCalc(int x, int y) {
    int count = 0;
    while (y > x) {
      count++;
      if (y % 2 == 0) {
        y /= 2;
      } else {
        y++;
      }
    }
    return count + x - y;
  }
}
