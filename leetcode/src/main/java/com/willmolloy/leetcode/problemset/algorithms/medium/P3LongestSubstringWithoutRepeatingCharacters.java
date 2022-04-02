package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/longest-substring-without-repeating-characters>https://leetcode.com/problems/longest-substring-without-repeating-characters</a>
 *
 * <p>Runtime: O(n) - single pass on s
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P3LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int max = 0;
    StringBuilder substring = new StringBuilder();

    for (char c : s.toCharArray()) {
      // stop adding 'c' to the substring once a repetition occurs
      if (substring.toString().indexOf(c) != -1) {
        // update the best length
        max = Math.max(substring.length(), max);
        // reset the substring to just after where the first 'c' occurred
        // e.g. substring = 'abcd' and 'c' = b, reset to 'cd'
        substring = new StringBuilder(substring.substring(substring.toString().indexOf(c) + 1));
      }
      substring.append(c);
    }
    return Math.max(substring.length(), max);
  }
}
