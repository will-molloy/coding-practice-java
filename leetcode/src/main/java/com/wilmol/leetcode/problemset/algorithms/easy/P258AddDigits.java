package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a href=https://leetcode.com/problems/add-digits>https://leetcode.com/problems/add-digits</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: converting number into its digits (use {@link Character#digit(char, int)})
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P258AddDigits {
  // TODO followup asks for O(1) runtime - probably some math trick

  public int addDigits(int num) {
    int sum = num;
    while (num > 9) {
      sum = 0;
      for (char c : String.valueOf(num).toCharArray()) {
        sum += Character.digit(c, 10);
      }
      num = sum;
    }
    return sum;
  }
}
