package com.wilmol.hackerrank.interview_preparation_kit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class RepeatedStringTest {

  @Test
  void _repeat3TimesWithRemainder() {
    assertThat(RepeatedString.repeatedString("aba", 10)).isEqualTo(7L);
  }

  @Test
  void _repeatOneTrillionTimesWithNoRemainder() {
    assertThat(RepeatedString.repeatedString("a", 1_000_000_000_000L))
        .isEqualTo(1_000_000_000_000L);
  }
}
