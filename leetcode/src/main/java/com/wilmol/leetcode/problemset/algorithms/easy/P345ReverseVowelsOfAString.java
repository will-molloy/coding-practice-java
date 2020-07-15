package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-vowels-of-a-string>https://leetcode.com/problems/reverse-vowels-of-a-string/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Two pointers traversing inwards; iterate each to next vowel.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P151ReverseWordsInAString
 * @see P344ReverseString
 * @see P541ReverseString2
 * @see P557ReverseWordsInAString3
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P345ReverseVowelsOfAString {

  public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;

    int l = 0;
    int r = n - 1;
    while (l < r) {
      while (l < r && !isVowel(chars[l])) {
        l++;
      }
      while (l < r && !isVowel(chars[r])) {
        r--;
      }
      swap(chars, l, r);
      l++;
      r--;
    }
    return new String(chars);
  }

  private boolean isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        || (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
  }

  private void swap(char[] chars, int a, int b) {
    char temp = chars[a];
    chars[a] = chars[b];
    chars[b] = temp;
  }
}
