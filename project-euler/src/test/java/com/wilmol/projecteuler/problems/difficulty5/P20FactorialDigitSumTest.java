package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P20FactorialDigitSumTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P20FactorialDigitSumTest {

  private final P20FactorialDigitSum factorialDigitSum = new P20FactorialDigitSum();

  @Test
  void test10Factorial() {
    assertThat(factorialDigitSum.apply(10)).isEqualTo(27);
  }

  @Test
  void test100Factorial() {
    assertThat(factorialDigitSum.apply(100)).isEqualTo(648);
  }
}
