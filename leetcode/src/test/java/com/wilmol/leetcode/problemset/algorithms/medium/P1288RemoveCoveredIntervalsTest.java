package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1288RemoveCoveredIntervalsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1288RemoveCoveredIntervalsTest {

  private final P1288RemoveCoveredIntervals p1288 = new P1288RemoveCoveredIntervals();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] intervals, int expected) {
    assertThat(p1288.removeCoveredIntervals(intervals)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 4}, {3, 6}, {2, 8}}, 2),
        Arguments.of(new int[][] {{1, 4}, {2, 3}}, 1),
        Arguments.of(new int[][] {{0, 10}, {5, 12}}, 2),
        Arguments.of(new int[][] {{3, 10}, {4, 10}, {5, 11}}, 2),
        Arguments.of(new int[][] {{1, 2}, {1, 4}, {3, 4}}, 1));
  }
}
