package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-words-in-a-string-iii>https://leetcode.com/problems/reverse-words-in-a-string-iii/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Reverse word by word and join again. (Cheating? Otherwise reverse up to index of next
 * {@code ' '}.)
 *
 * @see P344ReverseString
 * @see P541ReverseString2
 * @see P345ReverseVowelsOfAString
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P557ReverseWordsInAString3 {

  public String reverseWords(String s) {
    String[] words = s.split(" ");
    return Arrays.stream(words).map(word -> reverse(word)).collect(Collectors.joining(" "));
  }

  private String reverse(String s) {
    char[] chars = s.toCharArray();
    int l = 0;
    int r = chars.length - 1;
    while (l < r) {
      swap(chars, l, r);
      l++;
      r--;
    }
    return new String(chars);
  }

  private void swap(char[] chars, int a, int b) {
    char temp = chars[a];
    chars[a] = chars[b];
    chars[b] = temp;
  }
}
