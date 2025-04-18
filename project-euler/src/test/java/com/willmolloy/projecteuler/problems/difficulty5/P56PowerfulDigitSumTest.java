package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P56PowerfulDigitSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P56PowerfulDigitSumTest {

  @Test
  void testRangeUpTo100() {
    assertThat(P56PowerfulDigitSum.solve(100)).isEqualTo(972);
  }
}
