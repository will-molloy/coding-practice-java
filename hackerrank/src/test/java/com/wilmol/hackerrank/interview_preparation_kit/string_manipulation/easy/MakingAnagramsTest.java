package com.wilmol.hackerrank.interview_preparation_kit.string_manipulation.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.string_manipulation.easy.MakingAnagrams.makeAnagram;

import org.junit.jupiter.api.Test;

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
