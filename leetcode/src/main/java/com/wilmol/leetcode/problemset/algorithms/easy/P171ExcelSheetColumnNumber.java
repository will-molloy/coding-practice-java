package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/excel-sheet-column-number>https://leetcode.com/problems/excel-sheet-column-number</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: ((0.x + a).x + b).x + c = c.x<sup>0</sup> + b.x<sup>1</sup> + a.x<sup>2</sup>, avoids the
 * need to use {@link Math#pow} and iterate in reverse.
 *
 * @see P168ExcelSheetColumnTitle
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P171ExcelSheetColumnNumber {

  public int titleToNumber(String s) {
    int n = 0;
    for (char c : s.toCharArray()) {
      n = n * 26 + toInt(c);
    }
    return n;
  }

  // c : [A, Z]
  private int toInt(char c) {
    return c - 'A' + 1;
  }
}
