package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 16/03/2019. */
class P2EvenFibonacciNumbersTest {

  @Test
  void evenFibonacciNumbers() {
    assertThat(new P2EvenFibonacciNumbers().apply(100)).isEqualTo(44);
    assertThat(new P2EvenFibonacciNumbers().apply(4_000_000)).isEqualTo(4_613_732);
  }
}
