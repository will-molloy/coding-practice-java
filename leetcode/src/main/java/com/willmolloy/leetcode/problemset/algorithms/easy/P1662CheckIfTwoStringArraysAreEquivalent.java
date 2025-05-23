package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent>https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/</a>
 *
 * <p>Runtime: O(w1 + w2)
 *
 * <p>Extra memory: O(w1 + w2)
 *
 * <p>Key idea: {@link String#join}
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1662CheckIfTwoStringArraysAreEquivalent {

  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    return String.join("", word1).equals(String.join("", word2));
  }
}
