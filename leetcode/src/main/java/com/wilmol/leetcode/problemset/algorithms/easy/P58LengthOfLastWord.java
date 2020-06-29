package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/length-of-last-word>https://leetcode.com/problems/length-of-last-word</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: knowledge of {@link String} class.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P58LengthOfLastWord {

  public int lengthOfLastWord(String s) {
    String[] split = s.split(" ");
    if (split.length > 0) {
      return split[split.length - 1].length();
    }
    return 0;
  }
}
