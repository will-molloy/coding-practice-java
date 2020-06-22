package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.jupiter.api.Test;

/** Created by Will on 17/03/2019. */
class P19CountingSundaysTest {

  @Test
  void firstOfMonthDuring21stCentury() {
    assertThat(
            new P19CountingSundays()
                .onFirstOfMonth(
                    LocalDateTime.of(1901, Month.JANUARY, 1, 0, 0),
                    LocalDateTime.of(2000, Month.DECEMBER, 31, 0, 0)))
        .isEqualTo(171);
  }
}
