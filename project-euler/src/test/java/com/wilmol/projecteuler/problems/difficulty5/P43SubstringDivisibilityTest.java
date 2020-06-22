package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-20 at 11:49 AM. */
class P43SubstringDivisibilityTest {

  @Test
  void sumAllPandigitalNumbersWithThisProperty() {
    assertThat(P43SubstringDivisibility.pandigitalSumWithDivisibility()).isEqualTo(16_695_334_890L);
  }
}
