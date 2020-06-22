package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 17/03/2019. */
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
