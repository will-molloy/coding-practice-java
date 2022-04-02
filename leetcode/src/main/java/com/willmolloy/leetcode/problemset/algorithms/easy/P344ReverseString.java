package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-string>https://leetcode.com/problems/reverse-string/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: Two pointers moving inwards.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P151ReverseWordsInAString
 * @see P541ReverseString2
 * @see P557ReverseWordsInAString3
 * @see P345ReverseVowelsOfAString
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P344ReverseString {

  public void reverseString(char[] s) {
    int l = 0;
    int r = s.length - 1;
    while (l < r) {
      swap(s, l, r);
      l++;
      r--;
    }
  }

  private void swap(char[] chars, int a, int b) {
    char temp = chars[a];
    chars[a] = chars[b];
    chars[b] = temp;
  }
}
