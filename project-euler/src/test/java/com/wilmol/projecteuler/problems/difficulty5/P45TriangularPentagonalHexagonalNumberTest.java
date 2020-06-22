package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-20 at 3:05 PM. */
class P45TriangularPentagonalHexagonalNumberTest {

  @Test
  void firstTriangularPentagonalHexagonalNumber() {
    assertThat(P45TriangularPentagonalHexagonalNumber.nTriangularPentagonalHexagonalNumber(1))
        .isEqualTo(1L);
  }

  @Test
  void secondTriangularPentagonalHexagonalNumber() {
    assertThat(P45TriangularPentagonalHexagonalNumber.nTriangularPentagonalHexagonalNumber(2))
        .isEqualTo(40_755L);
  }

  @Test
  void thirdTriangularPentagonalHexagonalNumber() {
    assertThat(P45TriangularPentagonalHexagonalNumber.nTriangularPentagonalHexagonalNumber(3))
        .isEqualTo(1_533_776_805L);
  }
}
