package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-22 at 3:55 PM. */
class P53CombinatoricSelectionsTest {

  @Test
  void testNUpTo100() {
    assertThat(P53CombinatoricSelections.countGreaterThanOneMillion(100)).isEqualTo(4075);
  }

  @Test
  void testNUpTo23() {
    assertThat(P53CombinatoricSelections.countGreaterThanOneMillion(23)).isEqualTo(4);
  }
}
