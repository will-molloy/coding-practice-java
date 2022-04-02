package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1492TheKthFactorOfNTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1492TheKthFactorOfNTest {

  @ParameterizedTest
  @MethodSource
  void examples(int n, int k, int expected) {
    assertThat(new P1492TheKthFactorOfN().kthFactor(n, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(12, 3, 3),
        Arguments.of(7, 2, 7),
        Arguments.of(4, 4, -1),
        Arguments.of(1, 1, 1),
        Arguments.of(1000, 3, 4));
  }
}
