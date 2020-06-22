package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-05-02. */
class P56PowerfulDigitSumTest {

  @Test
  void testRangeUpTo100() {
    assertThat(P56PowerfulDigitSum.solve(100)).isEqualTo(972);
  }
}
