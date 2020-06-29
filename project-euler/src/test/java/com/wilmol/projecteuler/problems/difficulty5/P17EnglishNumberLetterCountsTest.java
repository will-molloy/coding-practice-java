package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P17EnglishNumberLetterCountsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P17EnglishNumberLetterCountsTest {

  @Test
  void englishNumberLetterCounts() {
    assertThat(new P17EnglishNumberLetterCounts().apply(1, 5)).isEqualTo(19);
    assertThat(new P17EnglishNumberLetterCounts().apply(342, 342)).isEqualTo(23);
    assertThat(new P17EnglishNumberLetterCounts().apply(115, 115)).isEqualTo(20);
    assertThat(new P17EnglishNumberLetterCounts().apply(1, 1000)).isEqualTo(21124);
  }
}
