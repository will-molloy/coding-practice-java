package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P3LongestSubstringWithoutRepeatingCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P3LongestSubstringWithoutRepeatingCharactersTest {

  private final P3LongestSubstringWithoutRepeatingCharacters function =
      new P3LongestSubstringWithoutRepeatingCharacters();

  @Test
  void example1SingleRepetition() {
    assertThat(function.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
  }

  @Test
  void example2SameCharacter() {
    assertThat(function.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
  }

  @Test
  void example3LongerSubsequenceMustBeIgnored() {
    // pwke is a subsequence of length '4'
    // actually the longest subsequence problem is more difficult!
    assertThat(function.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
  }
}
