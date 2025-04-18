package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P48SelfPowersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P48SelfPowersTest {

  @Test
  void sumSelfPowers1To10() {
    assertThat(P48SelfPowers.lastDigitsOfSelfPowersSumSeries(10, -1)).isEqualTo("10405071317");
  }

  @Test
  void sumSelfPowers1To1000Last10Digits() {
    assertThat(P48SelfPowers.lastDigitsOfSelfPowersSumSeries(1000, 10)).isEqualTo("9110846700");
  }
}
