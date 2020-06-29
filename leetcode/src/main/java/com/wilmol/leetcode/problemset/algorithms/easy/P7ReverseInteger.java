package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-integer>https://leetcode.com/problems/reverse-integer</a>
 *
 * <p>Runtime: O(n) (num digits in n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P7ReverseInteger {

  public int reverse(int x) {
    int out = 0;
    boolean neg = x < 0;
    if (neg) {
      x *= -1;
    }

    while (x > 0) {
      int lowestDigit = x % 10;
      int newOut = out * 10 + lowestDigit;

      // Overflow check
      if ((newOut - lowestDigit) / 10 != out) {
        return 0;
      }
      out = newOut;
      x /= 10;
    }

    return neg ? out * -1 : out;
  }
}
