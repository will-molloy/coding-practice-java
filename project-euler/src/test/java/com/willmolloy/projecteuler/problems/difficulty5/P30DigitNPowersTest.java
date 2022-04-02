package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P30DigitNPowersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P30DigitNPowersTest {

  private final P30DigitNPowers digitNPowers = new P30DigitNPowers();

  @Test
  void allNumbers4thPower() {
    assertThat(digitNPowers.apply(4)).isEqualTo(19_316L);
  }

  @Test
  void allNumbers5thPower() {
    assertThat(digitNPowers.apply(5)).isEqualTo(443_839L);
  }
}
