package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/largest-substring-between-two-equal-characters>https://leetcode.com/problems/largest-substring-between-two-equal-characters/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Try all characters.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1624LargestSubstringBetweenTwoEqualCharacters {

  // TODO single pass solution

  // O(26 * n) = O(n)
  public int maxLengthBetweenEqualCharacters(String s) {
    int max = -1;
    for (char c = 'a'; c <= 'z'; c++) {
      int first = s.indexOf(c);
      int last = s.lastIndexOf(c);
      if (first != last) {
        // (first, last)
        int size = last - first - 1;
        max = Math.max(max, size);
      }
    }
    return max;
  }
}
