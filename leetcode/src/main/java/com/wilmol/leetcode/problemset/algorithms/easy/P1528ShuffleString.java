package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/shuffle-string>https://leetcode.com/problems/shuffle-string/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Construct new string.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1528ShuffleString {

  public String restoreString(String s, int[] indices) {
    char[] chars = new char[indices.length];
    for (int i = 0; i < s.length(); i++) {
      chars[indices[i]] = s.charAt(i);
    }
    return new String(chars);
  }
}
