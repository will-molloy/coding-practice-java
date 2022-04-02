package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/decoded-string-at-index>https://leetcode.com/problems/decoded-string-at-index/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: First compute the size, then work backwards to the specific character.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P880DecodedStringAtIndex {

  public String decodeAtIndex(String s, int k) {
    long size = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        size *= Character.digit(c, 10);
      } else {
        size += 1;
      }
    }

    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      k %= size;
      if (Character.isLetter(c)) {
        if (k == 0) {
          return String.valueOf(c);
        }
        size -= 1;
      } else {
        size /= Character.digit(c, 10);
      }
    }

    throw new AssertionError();
  }
}
