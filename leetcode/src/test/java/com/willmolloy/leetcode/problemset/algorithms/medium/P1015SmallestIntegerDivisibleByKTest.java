package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1015SmallestIntegerDivisibleByKTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1015SmallestIntegerDivisibleByKTest {

  private final P1015SmallestIntegerDivisibleByK p1015 = new P1015SmallestIntegerDivisibleByK();

  @ParameterizedTest
  @MethodSource
  void examples(int k, int expected) {
    assertThat(p1015.smallestRepunitDivByK(k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(1, 1), Arguments.of(2, -1), Arguments.of(3, 3));
  }
}
