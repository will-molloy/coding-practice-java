package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/smallest-subsequence-of-distinct-characters>https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a>
 *
 * <p>Duplicate of {@link P316RemoveDuplicateLetters}.
 *
 * @see P316RemoveDuplicateLetters
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1081SmallestSubsequenceOfDistinctCharacters {

  private final P316RemoveDuplicateLetters delegate = new P316RemoveDuplicateLetters();

  public String smallestSubsequence(String s) {
    return delegate.removeDuplicateLetters(s);
  }
}
