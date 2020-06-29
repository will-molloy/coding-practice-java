package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P16PowerDigitSumTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P16PowerDigitSumTest {

  @Test
  void powerDigitSum() {
    assertThat(new P16PowerDigitSum().apply(2, 15)).isEqualTo(26);
    assertThat(new P16PowerDigitSum().apply(2, 1000)).isEqualTo(1366);
  }
}
