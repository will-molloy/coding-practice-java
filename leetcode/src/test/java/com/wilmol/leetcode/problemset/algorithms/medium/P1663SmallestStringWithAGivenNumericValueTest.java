package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1663SmallestStringWithAGivenNumericValueTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1663SmallestStringWithAGivenNumericValueTest {

  private final P1663SmallestStringWithAGivenNumericValue p1663 =
      new P1663SmallestStringWithAGivenNumericValue();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int k, String expected) {
    assertThat(p1663.getSmallestString(n, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(3, 27, "aay"), Arguments.of(5, 73, "aaszz"));
  }
}
