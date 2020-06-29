package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P25NDigitFibonacciNumberTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P25NDigitFibonacciNumberTest {

  private final P25NDigitFibonacciNumber nDigitFibonacciNumber = new P25NDigitFibonacciNumber();

  @Test
  void indexOfFirstTermWith3Digits() {
    assertThat(nDigitFibonacciNumber.fibIndex(3)).isEqualTo(12);
  }

  @Test
  void indexOfFirstTermWith1000Digits() {
    assertThat(nDigitFibonacciNumber.fibIndex(1000)).isEqualTo(4782);
  }
}
