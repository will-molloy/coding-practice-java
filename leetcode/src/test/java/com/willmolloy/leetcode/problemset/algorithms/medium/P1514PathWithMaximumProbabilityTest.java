package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1514PathWithMaximumProbabilityTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1514PathWithMaximumProbabilityTest {

  private final P1514PathWithMaximumProbability p1514 = new P1514PathWithMaximumProbability();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int[][] edges, double[] succProb, int start, int end, double expected) {
    assertThat(p1514.maxProbability(n, edges, succProb, start, end)).isWithin(1e-5).of(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            3, new int[][] {{0, 1}, {1, 2}, {0, 2}}, new double[] {0.5, 0.5, 0.2}, 0, 2, 0.25),
        Arguments.of(
            3, new int[][] {{0, 1}, {1, 2}, {0, 2}}, new double[] {0.5, 0.5, 0.3}, 0, 2, 0.3),
        Arguments.of(3, new int[][] {{0, 1}}, new double[] {0.5}, 0, 2, 0));
  }
}
