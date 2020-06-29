package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1MultiplesOf3And5Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1MultiplesOf3And5Test {

  @Test
  void multiplesOf3And5() {
    assertThat(new P1MultiplesOf3And5().solve(10)).isEqualTo(23);
    assertThat(new P1MultiplesOf3And5().solve(1_000)).isEqualTo(233_168);
  }
}
