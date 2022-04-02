package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1051HeightCheckerTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1051HeightCheckerTest {

  private final P1051HeightChecker p1051 = new P1051HeightChecker();

  @ParameterizedTest
  @MethodSource
  void examples(int[] heights, int expected) {
    assertThat(p1051.heightChecker(heights)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 4, 2, 1, 3}, 3),
        Arguments.of(new int[] {5, 1, 2, 3, 4}, 5),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, 0));
  }
}
