package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1007MinimumDominoRotationsForEqualRowTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1007MinimumDominoRotationsForEqualRowTest {

  private final P1007MinimumDominoRotationsForEqualRow p1007 =
      new P1007MinimumDominoRotationsForEqualRow();

  @ParameterizedTest
  @MethodSource
  void examples(int[] a, int[] b, int expected) {
    assertThat(p1007.minDominoRotations(a, b)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 1, 2, 4, 2, 2}, new int[] {5, 2, 6, 2, 3, 2}, 2),
        Arguments.of(new int[] {3, 5, 1, 2, 3}, new int[] {3, 6, 3, 3, 4}, -1));
  }
}
