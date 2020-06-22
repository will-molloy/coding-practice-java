package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-05-19 at 16:56. */
class P57SquareRootConvergentsTest {

  @Test
  void countInFirst10() {
    assertThat(P57SquareRootConvergents.solve(10)).isEqualTo(1);
  }

  @Test
  void countInFirst1000() {
    assertThat(P57SquareRootConvergents.solve(1000)).isEqualTo(153);
  }
}
