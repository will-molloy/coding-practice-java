package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1486XorOperationInAnArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1486XorOperationInAnArrayTest {

  private final P1486XorOperationInAnArray p1486 = new P1486XorOperationInAnArray();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int start, int expected) {
    assertThat(p1486.xorOperation(n, start)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(5, 0, 8),
        Arguments.of(4, 3, 8),
        Arguments.of(1, 7, 7),
        Arguments.of(10, 5, 2));
  }
}
