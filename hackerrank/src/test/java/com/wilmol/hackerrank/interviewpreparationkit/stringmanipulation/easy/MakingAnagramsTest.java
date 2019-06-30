package com.wilmol.hackerrank.interviewpreparationkit.stringmanipulation.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interviewpreparationkit.stringmanipulation.easy.MakingAnagrams.makeAnagram;

import org.junit.jupiter.api.Test;

/** Created by Will on 30/03/2019. */
class MakingAnagramsTest {

  @Test
  void remove4() {
    assertThat(makeAnagram("abc", "cde")).isEqualTo(4);
  }

  @Test
  void removeNone() {
    assertThat(makeAnagram("ababa", "baaba")).isEqualTo(0);
  }

  @Test
  void removeAll() {
    assertThat(makeAnagram("xxxyyyzzz", "aaabbbccc")).isEqualTo(18);
  }
}
