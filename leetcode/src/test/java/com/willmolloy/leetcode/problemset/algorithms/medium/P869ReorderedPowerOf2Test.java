package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P869ReorderedPowerOf2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P869ReorderedPowerOf2Test {

  private final P869ReorderedPowerOf2 p869ReorderedPowerOf2 = new P869ReorderedPowerOf2();

  @ParameterizedTest
  @MethodSource
  void examples(int n, boolean expected) {
    assertThat(p869ReorderedPowerOf2.reorderedPowerOf2(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(1, true),
        Arguments.of(10, false),
        Arguments.of(16, true),
        Arguments.of(24, false),
        Arguments.of(46, true));
  }
}
