package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/excel-sheet-column-title>https://leetcode.com/problems/excel-sheet-column-title</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: Adding {@code n -= 1} so don't have to deal with issue where {@code 26 % 26 = 0}.
 * Off by one errors!
 *
 * @see P171ExcelSheetColumnNumber
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P168ExcelSheetColumnTitle {

  public String convertToTitle(int n) {
    StringBuilder s = new StringBuilder();
    while (n > 0) {
      n -= 1;
      s.insert(0, toChar(n % 26));
      n /= 26;
    }
    return s.toString();
  }

  // i : [0, 25]
  private char toChar(int i) {
    return (char) ('A' + i);
  }
}
