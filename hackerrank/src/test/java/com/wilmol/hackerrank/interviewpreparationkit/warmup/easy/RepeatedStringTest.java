package com.wilmol.hackerrank.interviewpreparationkit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 24/03/2019. */
class RepeatedStringTest {

  @Test
  void repeat3TimesWithRemainder() {
    assertThat(RepeatedString.repeatedString("aba", 10)).isEqualTo(7L);
  }

  @Test
  void repeatOneTrillionTimesWithNoRemainder() {
    assertThat(RepeatedString.repeatedString("a", 1_000_000_000_000L))
        .isEqualTo(1_000_000_000_000L);
  }
}
