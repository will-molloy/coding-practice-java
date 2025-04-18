package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-string-ii>https://leetcode.com/problems/reverse-string-ii/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: Reverse in chunks of size {@code k} (i.e. {@code [i, i + k)}). Can just use {@link
 * Math#min} to cover case where k covers the rest of the array.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P151ReverseWordsInAString
 * @see P344ReverseString
 * @see P557ReverseWordsInAString3
 * @see P345ReverseVowelsOfAString
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P541ReverseString2 {

  public String reverseStr(String s, int k) {
    int n = s.length();
    char[] chars = s.toCharArray();

    for (int i = 0; i < n; ) {
      // reverse [i, i + k) = [l, r]
      int l = i;
      int r = Math.min(n - 1, i + k - 1);
      while (l < r) {
        swap(chars, l, r);
        l++;
        r--;
      }
      // skip next k too
      i += 2 * k;
    }
    return new String(chars);
  }

  private void swap(char[] chars, int a, int b) {
    char temp = chars[a];
    chars[a] = chars[b];
    chars[b] = temp;
  }
}
