package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://leetcode.com/problems/string-to-integer-atoi>https://leetcode.com/problems/string-to-integer-atoi</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P8StringToIntegerAtoi {

  private static final Pattern VALID_START = Pattern.compile("^ *[\\-+]?\\d+.*");

  private static final Pattern NON_DIGIT = Pattern.compile("\\D");

  public int myAtoi(String s) {
    // check valid input
    if (!VALID_START.matcher(s).matches()) {
      return 0;
    }

    // replace redundant leading spaces/plus sign
    s = s.replaceFirst("^( +)(?!$)", "");
    s = s.replaceFirst("^\\+(?!$)", "");

    // check if negative
    boolean negative = s.startsWith("-");
    if (negative) {
      // remove leading '-'
      s = s.substring(1);
    }

    // remove suffix from first non digit character
    Matcher m = NON_DIGIT.matcher(s);
    if (m.find()) {
      s = s.substring(0, m.start());
    }

    // remove leading zeros
    s = s.replaceFirst("^0+(?!$)", "");

    // extract result
    int multiplier = (int) Math.pow(10, s.length() - 1);
    long result = 0;
    for (char c : s.toCharArray()) {
      long val = Character.getNumericValue(c) * multiplier;
      boolean valOverflowed = val > 10 && val % 10 != 0 || multiplier != 1 && multiplier % 10 != 0;
      if (valOverflowed) {
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      if (negative) {
        result -= val;
        if (result <= Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
        }
      } else {
        result += val;
        if (result >= Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        }
      }
      multiplier /= 10;
    }
    return (int) result;
  }
}
