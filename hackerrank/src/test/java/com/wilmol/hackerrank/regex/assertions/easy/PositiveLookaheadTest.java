package com.wilmol.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class PositiveLookaheadTest {

  @Test
  void testMatchCount() {
    assertThat(new PositiveLookahead().matchCount("gooooo!")).isEqualTo(3L);
    assertThat(new PositiveLookahead().matchCount("oooooogooo")).isEqualTo(5L);
    assertThat(new PositiveLookahead().matchCount("googoogoogooo")).isEqualTo(1L);
    assertThat(new PositiveLookahead().matchCount("goooglooo!")).isEqualTo(2L);
  }
}
