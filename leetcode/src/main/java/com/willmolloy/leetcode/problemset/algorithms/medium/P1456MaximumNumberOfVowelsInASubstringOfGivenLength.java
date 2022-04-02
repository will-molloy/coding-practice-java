package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length>https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Sliding window.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1456MaximumNumberOfVowelsInASubstringOfGivenLength {

  public int maxVowels(String s, int k) {
    int n = s.length();

    int max = 0;
    int count = 0;
    // initial window
    for (int i = 0; i < k; i++) {
      if (isVowel(s.charAt(i))) {
        count++;
      }
    }
    max = count;

    // sliding window
    for (int i = k; i < n; i++) {
      // remove start
      if (isVowel(s.charAt(i - k))) {
        count--;
      }
      // add end
      if (isVowel(s.charAt(i))) {
        count++;
      }
      max = Math.max(max, count);
    }

    return max;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
