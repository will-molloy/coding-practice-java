package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P57SquareRootConvergentsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P57SquareRootConvergentsTest {

  @Test
  void countInFirst10() {
    assertThat(P57SquareRootConvergents.solve(10)).isEqualTo(1);
  }

  @Test
  void countInFirst1000() {
    assertThat(P57SquareRootConvergents.solve(1000)).isEqualTo(153);
  }
}
