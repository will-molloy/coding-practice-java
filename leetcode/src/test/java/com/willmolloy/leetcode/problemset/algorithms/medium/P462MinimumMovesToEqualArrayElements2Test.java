package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P462MinimumMovesToEqualArrayElements2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P462MinimumMovesToEqualArrayElements2Test {

  private final P462MinimumMovesToEqualArrayElements2 p462MinimumMovesToEqualArrayElements2 =
      new P462MinimumMovesToEqualArrayElements2();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p462MinimumMovesToEqualArrayElements2.minMoves2(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3}, 2), Arguments.of(new int[] {1, 10, 2, 9}, 16));
  }
}
