package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1137NthTribonacciNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1137NthTribonacciNumberTest {

  private final P1137NthTribonacciNumber fun = new P1137NthTribonacciNumber();

  @ParameterizedTest
  @MethodSource("test")
  void test(int n, int fn) {
    assertThat(fun.tribonacci(n)).isEqualTo(fn);
  }

  static Stream<Arguments> test() {
    return Stream.of(
        Arguments.of(0, 0),
        Arguments.of(1, 1),
        Arguments.of(2, 1),
        Arguments.of(4, 4),
        Arguments.of(25, 1_389_537),
        Arguments.of(37, 2_082_876_103));
  }
}
