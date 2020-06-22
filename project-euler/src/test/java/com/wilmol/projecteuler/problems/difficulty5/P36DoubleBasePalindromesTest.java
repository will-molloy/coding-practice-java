package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-19 at 3:05 PM. */
class P36DoubleBasePalindromesTest {

  @Test
  void sumBelow1M() {
    assertThat(P36DoubleBasePalindromes.doubleBasePalindromeSum(1_000_000)).isEqualTo(872187);
  }
}
