package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1094CarPoolingTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1094CarPoolingTest {

  private final P1094CarPooling p1094 = new P1094CarPooling();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] trips, int capacity, boolean expected) {
    assertThat(p1094.carPooling(trips, capacity)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[][] {{2, 1, 5}, {3, 3, 7}}, 4, false),
        Arguments.of(new int[][] {{2, 1, 5}, {3, 3, 7}}, 5, true),
        Arguments.of(new int[][] {{2, 1, 5}, {3, 5, 7}}, 3, true),
        Arguments.of(new int[][] {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11, true));
  }
}
