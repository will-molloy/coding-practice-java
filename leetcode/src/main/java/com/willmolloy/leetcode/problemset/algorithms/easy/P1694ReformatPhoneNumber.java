package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/reformat-phone-number>https://leetcode.com/problems/reformat-phone-number/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: First get the digits, then build result by adding 3 digits until 4 are left and
 * handling the 3 cases.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1694ReformatPhoneNumber {

  public String reformatNumber(String number) {
    String digits = number.replaceAll("\\D", "");

    StringBuilder result = new StringBuilder();
    int i;
    for (i = 0; i < digits.length() - 4; i += 3) {
      result.append(digits, i, i + 3).append("-");
    }
    if (i == digits.length() - 4) {
      result.append(digits, i, i + 2).append("-");
      i += 2;
    }
    result.append(digits.substring(i));
    return result.toString();
  }
}
