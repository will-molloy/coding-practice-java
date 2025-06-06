package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/add-digits>https://leetcode.com/problems/add-digits</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: converting number into its digits (use {@link Character#digit(char, int)})
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P258AddDigits {
  // TODO followup asks for O(1) runtime - probably some math trick

  public int addDigits(int num) {
    while (num > 9) {
      int digitSum = 0;
      int numCopy = num;
      while (numCopy > 0) {
        digitSum += numCopy % 10;
        numCopy /= 10;
      }
      num = digitSum;
    }
    return num;
  }
}
