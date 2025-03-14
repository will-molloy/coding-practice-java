package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/license-key-formatting>https://leetcode.com/problems/license-key-formatting/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Use separate variable to track length of added characters excluding dashes.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P482LicenseKeyFormatting {

  public String licenseKeyFormatting(String s, int k) {
    int n = s.length();

    StringBuilder sb = new StringBuilder();
    int len = 0;

    // reverse order so don't have to precompute size of first group
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '-') {
        continue;
      }
      // only add '-' if we're going to add more characters, so do it first
      if (len > 0 && len % k == 0) {
        sb.append('-');
      }
      sb.append(Character.toUpperCase(s.charAt(i)));
      len++;
    }
    return sb.reverse().toString();
  }
}
