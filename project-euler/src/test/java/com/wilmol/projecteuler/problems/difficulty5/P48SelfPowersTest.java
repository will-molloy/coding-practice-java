package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-21 at 12:35 PM. */
class P48SelfPowersTest {

  @Test
  void sumSelfPowers1To10() {
    assertThat(P48SelfPowers.lastDigitsOfSelfPowersSumSeries(10, -1)).isEqualTo("10405071317");
  }

  @Test
  void sumSelfPowers1To1000Last10Digits() {
    assertThat(P48SelfPowers.lastDigitsOfSelfPowersSumSeries(1000, 10)).isEqualTo("9110846700");
  }
}
