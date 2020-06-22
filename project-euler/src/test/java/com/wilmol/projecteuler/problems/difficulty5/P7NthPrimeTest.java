package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 16/03/2019. */
class P7NthPrimeTest {

  private final P7NthPrime nthPrime = new P7NthPrime();

  @Test
  void test6thPrime() {
    assertThat(nthPrime.apply(6)).isEqualTo(13);
  }

  @Test
  void test10001stPrime() {
    assertThat(nthPrime.apply(10_001)).isEqualTo(104_743);
  }
}
