package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/smallest-subsequence-of-distinct-characters>https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a>
 *
 * <p>Duplicate of {@link P316RemoveDuplicateLetters}.
 *
 * @see P316RemoveDuplicateLetters
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1081SmallestSubsequenceOfDistinctCharacters {

  private final P316RemoveDuplicateLetters delegate = new P316RemoveDuplicateLetters();

  public String smallestSubsequence(String s) {
    return delegate.removeDuplicateLetters(s);
  }
}
