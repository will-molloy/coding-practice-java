package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P498DiagonalTraverseTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P498DiagonalTraverseTest {

  @ParameterizedTest
  @MethodSource("p498")
  void example(P498DiagonalTraverse p498) {
    assertThat(
            p498.findDiagonalOrder(
                new int[][] {
                  {1, 2, 3},
                  {4, 5, 6},
                  {7, 8, 9},
                }))
        .asList()
        .containsExactly(1, 2, 4, 7, 5, 3, 6, 8, 9)
        .inOrder();
  }

  static Stream<P498DiagonalTraverse> p498() {
    return Stream.of(
        new P498DiagonalTraverse.SimulateWalk(), new P498DiagonalTraverse.CollectDiagonals());
  }
}
