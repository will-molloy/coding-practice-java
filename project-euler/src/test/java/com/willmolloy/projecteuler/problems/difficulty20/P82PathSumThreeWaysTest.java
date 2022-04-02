package com.willmolloy.projecteuler.problems.difficulty20;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.projecteuler.problems.difficulty10.P81PathSumTwoWaysTest;
import org.junit.jupiter.api.Test;

/**
 * P82PathSumThreeWaysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P82PathSumThreeWaysTest {

  @Test
  void test5x5Matrix() {
    assertThat(P82PathSumThreeWays.shortestPath(P81PathSumTwoWaysTest.get5x5Matrix()))
        .isEqualTo(994);
  }

  @Test
  void test80x80Matrix() {
    assertThat(P82PathSumThreeWays.shortestPath(P81PathSumTwoWaysTest.get80x80Matrix()))
        .isEqualTo(260_324);
  }
}
