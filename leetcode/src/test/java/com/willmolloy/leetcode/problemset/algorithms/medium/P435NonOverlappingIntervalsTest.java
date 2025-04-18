package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P435NonOverlappingIntervalsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P435NonOverlappingIntervalsTest {

  private final P435NonOverlappingIntervals p435 = new P435NonOverlappingIntervals();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] intervals, int expected) {
    assertThat(p435.eraseOverlapIntervals(intervals)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}, 1),
        Arguments.of(new int[][] {{1, 2}, {1, 2}, {1, 2}}, 2),
        Arguments.of(new int[][] {{1, 2}, {2, 3}}, 0));
  }
}
