package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-words-in-a-string>https://leetcode.com/problems/reverse-words-in-a-string/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Split on multiple whitespace ({@code \s+}) so don't have to deal with multiple
 * spaces between words or empty words.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P344ReverseString
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P541ReverseString2
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P557ReverseWordsInAString3
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P345ReverseVowelsOfAString
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P151ReverseWordsInAString {

  public String reverseWords(String s) {
    String[] words = s.split("\\s+");
    reverse(words);
    return String.join(" ", words).trim();
  }

  private void reverse(String[] arr) {
    int l = 0;
    int r = arr.length - 1;
    while (l < r) {
      swap(arr, l++, r--);
    }
  }

  private void swap(String[] arr, int a, int b) {
    String temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
