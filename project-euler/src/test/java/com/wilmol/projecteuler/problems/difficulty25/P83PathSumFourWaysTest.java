package com.wilmol.projecteuler.problems.difficulty25;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.projecteuler.problems.difficulty10.P81PathSumTwoWaysTest;
import org.junit.jupiter.api.Test;

/** Created by Will on 2019-03-30 at 23:12. */
class P83PathSumFourWaysTest {

  @Test
  void test5x5Matrix() {
    assertThat(P83PathSumFourWays.shortestPath(P81PathSumTwoWaysTest.get5x5Matrix()))
        .isEqualTo(2297);
  }

  @Test
  void test80x80Matrix() {
    assertThat(P83PathSumFourWays.shortestPath(P81PathSumTwoWaysTest.get80x80Matrix()))
        .isEqualTo(425_185);
  }
}
