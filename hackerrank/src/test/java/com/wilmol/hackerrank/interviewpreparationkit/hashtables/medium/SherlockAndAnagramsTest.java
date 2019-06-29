package com.wilmol.hackerrank.interviewpreparationkit.hashtables.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class SherlockAndAnagramsTest {

  @Test
  void abba4AnagramPairs() {
    assertThat(SherlockAndAnagrams.sherlockAndAnagrams("abba")).isEqualTo(4);
  }

  @Test
  void abcdNoAnagramPairs() {
    assertThat(SherlockAndAnagrams.sherlockAndAnagrams("abcd")).isEqualTo(0);
  }

  @Test
  void ifailuhkqq3AnagramPairs() {
    assertThat(SherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq")).isEqualTo(3);
  }

  @Test
  void kkkk10AnagramPairs() {
    assertThat(SherlockAndAnagrams.sherlockAndAnagrams("kkkk")).isEqualTo(10);
  }

  @Test
  void cdcd5AnagramPairs() {
    assertThat(SherlockAndAnagrams.sherlockAndAnagrams("cdcd")).isEqualTo(5);
  }

  @Test
  void factorialProducesOverflow() {
    assertThat(
            SherlockAndAnagrams.sherlockAndAnagrams(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
        .isEqualTo(76_076);
  }
}
