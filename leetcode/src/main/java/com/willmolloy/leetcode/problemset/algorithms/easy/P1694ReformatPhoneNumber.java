package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/reformat-phone-number>https://leetcode.com/problems/reformat-phone-number/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: First get the digits, then build result by adding 3 digits until 4 are left and handling
 * the 3 cases.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1694ReformatPhoneNumber {

  public String reformatNumber(String number) {
    String digits = number.replaceAll("\\D", "");

    String result = "";
    int i;
    for (i = 0; i < digits.length() - 4; i += 3) {
      result += digits.substring(i, i + 3) + "-";
    }
    if (i == digits.length() - 4) {
      result += digits.substring(i, i + 2) + "-";
      i += 2;
    }
    result += digits.substring(i);
    return result;
  }
}
