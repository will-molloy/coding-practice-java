package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1697CheckingExistenceOfEdgeLimitedPathsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1697CheckingExistenceOfEdgeLimitedPathsTest {

  private final P1697CheckingExistenceOfEdgeLimitedPaths p1697CheckingExistenceOfEdgeLimitedPaths =
      new P1697CheckingExistenceOfEdgeLimitedPaths();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int[][] edges, int[][] queries, List<Boolean> expected) {
    assertThat(
            p1697CheckingExistenceOfEdgeLimitedPaths.distanceLimitedPathsExist(n, edges, queries))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            3,
            new int[][] {{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}},
            new int[][] {{0, 1, 2}, {0, 2, 5}},
            List.of(false, true)),
        Arguments.of(
            5,
            new int[][] {{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}},
            new int[][] {{0, 4, 14}, {1, 4, 13}},
            List.of(true, false)));
  }
}
