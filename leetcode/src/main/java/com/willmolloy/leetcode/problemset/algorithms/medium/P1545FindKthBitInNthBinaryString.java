package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * <a
 * href=https://leetcode.com/problems/find-kth-bit-in-nth-binary-string>https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/</a>
 *
 * <p>Runtime: O(2<sup>n</sup>), final invert is 2<sup>n</sup>/2 iterations TODO O(n) is possible
 *
 * <p>Extra memory: O(2<sup>n</sup>)
 *
 * <p>Key idea: n is small enough to bruteforce compute the string.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1545FindKthBitInNthBinaryString {

  @SuppressFBWarnings("SBSC_USE_STRINGBUFFER_CONCATENATION")
  public char findKthBit(int n, int k) {
    String s = "0";
    for (int i = 2; i <= n; i++) {
      s = s + "1" + reverse(invert(s));
    }
    return s.charAt(k - 1);
  }

  private String reverse(String s) {
    char[] chars = s.toCharArray();
    int l = 0;
    int r = chars.length - 1;
    while (l < r) {
      char temp = chars[l];
      chars[l] = chars[r];
      chars[r] = temp;
      l++;
      r--;
    }
    return new String(chars);
  }

  private String invert(String s) {
    StringBuilder next = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == '0') {
        next.append('1');
      } else {
        next.append('0');
      }
    }
    return next.toString();
  }
}
