package com.wilmol.leetcode.problems.easy;

/**
 * Created by Will on 2019-07-13 at 21:18.
 *
 * <p><a
 * href=https://leetcode.com/problems/palindrome-number>https://leetcode.com/problems/palindrome-number</a>
 *
 * <p>Runtime: O(n)
 */
class P9PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0 || x != 0 && x % 10 == 0) {
      // leading minus sign or trailing zeros (except 0 itself)
      return false;
    }
    if (x < 10) {
      // single digit
      return true;
    }
    int halfWay = 0;
    while (x > halfWay) {
      int lastDigit = x % 10;
      halfWay = halfWay * 10 + lastDigit;
      x /= 10;
    }
    return x == halfWay || x == halfWay / 10;
  }
}
