package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/to-lower-case>https://leetcode.com/problems/to-lower-case/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: {@code - 'A' + 'a'} will add the difference of upper/lower case ascii value and therefore
 * shifts the ascii value from upper to lower case.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P709ToLowerCase {

  public String toLowerCase(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        chars[i] = (char) (chars[i] - 'A' + 'a');
      }
    }
    return new String(chars);
  }
}
