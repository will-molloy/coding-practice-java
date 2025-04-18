package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/smallest-string-with-a-given-numeric-value>https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Result looks like {@code "a*[a-z]z*"} (with length n).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1663SmallestStringWithAGivenNumericValue {

  public String getSmallestString(int n, int k) {
    // initially all 'a's (with value n)
    char[] chars = new char[n];
    Arrays.fill(chars, 'a');
    int val = n;

    int i = n - 1;
    while (k - val > 0) {
      int rem = k - val;

      // promote last to at most z
      int last = 'a' - chars[i] + 1;
      int nextLast = Math.min(last + rem, 26);
      chars[i] = (char) ('a' + nextLast - 1);

      val += nextLast - last;
      i--;
    }
    return new String(chars);
  }
}
