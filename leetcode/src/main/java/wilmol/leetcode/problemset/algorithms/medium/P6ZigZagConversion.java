package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * Created by Will on 2019-07-13 at 14:45.
 *
 * <p><a
 * href=https://leetcode.com/problems/zigzag-conversion>https://leetcode.com/problems/zigzag-conversion</a>
 *
 * <p>Runtime: O(n) - one pass on characters in {@code s}
 */
class P6ZigZagConversion {

  public String convert(String s, int numRows) {
    if (numRows <= 1) {
      return s;
    }
    int i = 0;
    boolean forward = true;
    String[] array = new String[numRows];
    Arrays.fill(array, "");

    // Go until n (numRows), back and forth
    // storing in array of strings until input string is depleted
    // then join the array of strings
    // e.g. PAYPALISHIRING -> PAHNAPLSIIGYIR
    // i = 0: P   A   H   N
    // i = 1: A P L S I I G
    // i = 2: Y   I   R
    // i,e. i = (0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1)
    for (char c : s.toCharArray()) {
      array[i] += c;
      i += forward ? 1 : -1;
      if (i == numRows - 1 || i == 0) {
        forward = !forward;
      }
    }
    return String.join("", array);
  }
}
