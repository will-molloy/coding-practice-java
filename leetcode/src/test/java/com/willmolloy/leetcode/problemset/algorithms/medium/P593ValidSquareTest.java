package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P593ValidSquareTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P593ValidSquareTest {

  private final P593ValidSquare p593 = new P593ValidSquare();

  @ParameterizedTest
  @MethodSource
  void examples(int[] p1, int[] p2, int[] p3, int[] p4, boolean expected) {
    assertThat(p593.validSquare(p1, p2, p3, p4)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 1}, true),
        Arguments.of(
            new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 12}, false),
        Arguments.of(
            new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1}, true));
  }
}
