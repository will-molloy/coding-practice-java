package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P56PowerfulDigitSumTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P56PowerfulDigitSumTest {

  @Test
  void testRangeUpTo100() {
    assertThat(P56PowerfulDigitSum.solve(100)).isEqualTo(972);
  }
}
