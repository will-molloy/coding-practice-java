package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-05-25. */
class P1035UncrossedLinesTest {

  private final P1035UncrossedLines p1035 = new P1035UncrossedLines();

  @ParameterizedTest
  @MethodSource
  void examples(int[] a, int[] b, int expected) {
    assertThat(p1035.maxUncrossedLines(a, b)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 4, 2}, new int[] {1, 2, 4}, 2),
        Arguments.of(new int[] {2, 5, 1, 2, 5}, new int[] {10, 5, 2, 1, 5, 2}, 3),
        Arguments.of(new int[] {1, 3, 7, 1, 7, 5}, new int[] {1, 9, 2, 5, 1}, 2));
  }
}
