package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P29DistinctPowersTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P29DistinctPowersTest {

  private final P29DistinctPowers distinctPowers = new P29DistinctPowers();

  @Test
  void between2And5() {
    assertThat(distinctPowers.apply(2, 5)).isEqualTo(15);
  }

  @Test
  void between2And100() {
    assertThat(distinctPowers.apply(2, 100)).isEqualTo(9_183);
  }
}
