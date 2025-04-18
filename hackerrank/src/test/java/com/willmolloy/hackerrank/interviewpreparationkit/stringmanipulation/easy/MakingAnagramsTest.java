package com.willmolloy.hackerrank.interviewpreparationkit.stringmanipulation.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MakingAnagramsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MakingAnagramsTest {

  @Test
  void remove4() {
    assertThat(MakingAnagrams.makeAnagram("abc", "cde")).isEqualTo(4);
  }

  @Test
  void removeNone() {
    assertThat(MakingAnagrams.makeAnagram("ababa", "baaba")).isEqualTo(0);
  }

  @Test
  void removeAll() {
    assertThat(MakingAnagrams.makeAnagram("xxxyyyzzz", "aaabbbccc")).isEqualTo(18);
  }
}
